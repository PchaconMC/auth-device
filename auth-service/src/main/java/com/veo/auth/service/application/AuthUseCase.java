package com.veo.auth.service.application;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.veo.auth.service.domain.models.Token;
import com.veo.auth.service.domain.models.User;
import com.veo.auth.service.infrastructure.entitie.TokenEntity;
import com.veo.auth.service.infrastructure.entitie.UserEntity;
import com.veo.auth.service.infrastructure.inputport.AuthInputPort;
import com.veo.auth.service.infrastructure.outputport.AuthExternalProviderClientRest;
import com.veo.auth.service.infrastructure.outputport.TokenJpaRepository;
import com.veo.auth.service.infrastructure.outputport.UserJpaRepository;

@Component
public class AuthUseCase implements AuthInputPort {

		private final Logger logger = LoggerFactory.getLogger(AuthUseCase.class);
	
	   @Autowired
	   TokenJpaRepository tokenJpa;
	   @Autowired
	   UserJpaRepository userJpa;
	   
	   @Autowired
	   private AuthExternalProviderClientRest authRest;
	   
		@Override
		public Token auth( User user ) {
			
			UserEntity userEntity= userJpa.getByUser( user.user() );
			Token token = null;
			if(userEntity != null) {
			
			token = authRest.loginExternalProvider( user.user(), user.password() );
			
			
			TokenEntity tokenEntity = new TokenEntity();
			tokenEntity.setAsExpiresIn(token.asExpiresIn());
			tokenEntity.setAsRefreshToken(token.asRefreshToken());
			tokenEntity.setAsTypeToken(token.asTypeToken());
			tokenEntity.setAsToken(token.asToken());
			tokenEntity.setAsExpiresIn(token.asExpiresIn());
					//Asumimos que el UserId lo tenemos en el sistema e inicializado
			tokenEntity.setUserId(UUID.randomUUID().toString());
			tokenEntity.setDateUpdate(LocalDateTime.now());
			tokenJpa.save( tokenEntity );
			}else {
				//Lanzar una excepción usuario no se encuetra registrado en el sistema
				logger.info("El usuario no se encuentra registrado.");
			}
			return token;
		}

		@Override
		public List<UserEntity> getAll() {
			return userJpa.findAll();
		}

}
