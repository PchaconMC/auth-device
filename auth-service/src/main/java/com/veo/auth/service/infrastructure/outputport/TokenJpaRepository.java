package com.veo.auth.service.infrastructure.outputport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veo.auth.service.infrastructure.entitie.TokenEntity;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, Long> {

}
