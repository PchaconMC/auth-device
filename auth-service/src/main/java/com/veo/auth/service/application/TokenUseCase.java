package com.veo.auth.service.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.veo.auth.service.infrastructure.entitie.TokenEntity;
import com.veo.auth.service.infrastructure.inputport.TokenInputPort;
import com.veo.auth.service.infrastructure.outputport.TokenJpaRepository;

@Component
public class TokenUseCase implements TokenInputPort {
	@Autowired
	private TokenJpaRepository tokenJPA;
	
	@Override
	public List<TokenEntity> getAll() {
		return tokenJPA.findAll();
	}

}
