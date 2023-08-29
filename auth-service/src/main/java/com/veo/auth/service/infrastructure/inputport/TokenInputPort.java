package com.veo.auth.service.infrastructure.inputport;

import java.util.List;

import com.veo.auth.service.infrastructure.entitie.TokenEntity;

public interface TokenInputPort {
	public List<TokenEntity> getAll();
}
