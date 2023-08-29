package com.veo.auth.service.infrastructure.inputport;

import java.util.List;

import com.veo.auth.service.domain.models.Token;
import com.veo.auth.service.domain.models.User;
import com.veo.auth.service.infrastructure.entitie.UserEntity;

public interface AuthInputPort {

	public Token auth(User user);
	public List<UserEntity> getAll();
}
