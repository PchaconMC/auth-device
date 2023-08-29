package com.veo.auth.service.infrastructure.adapters.in;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veo.auth.service.domain.models.Token;
import com.veo.auth.service.domain.models.User;
import com.veo.auth.service.infrastructure.entitie.TokenEntity;
import com.veo.auth.service.infrastructure.entitie.UserEntity;
import com.veo.auth.service.infrastructure.inputport.AuthInputPort;
import com.veo.auth.service.infrastructure.inputport.TokenInputPort;


@RestController
@RequestMapping(value = "/")
public class AuthAPI {
	
	@Autowired
    AuthInputPort authInputPort;
	@Autowired
    TokenInputPort tokenInputPort;
/*
	@Autowired
	private CircuitBreakerFactory cbFactory;
	

	
	@GetMapping()
    public Token get( @RequestBody User user ) {
        return cbFactory.create("authCircuit")
        		.run(()->authInputPort.auth(user), e -> metodoAlternativo(user));
        }
	
	*/
	@GetMapping("login")
    public Token get( @RequestBody User user ) {
        return authInputPort.auth(user);
        }
	@GetMapping("user/getAll")
    public List<UserEntity> userGetAll(  ) {
        return authInputPort.getAll();
        }
	@GetMapping("token/getAll")
    public List<TokenEntity> tokenGetAll(  ) {
        return tokenInputPort.getAll();
        }
	public Token metodoAlternativo(User user) {
		//Token token = new Token();
		return null;
	}

}
