package com.veo.auth.service.infrastructure.outputport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veo.auth.service.infrastructure.entitie.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
    @Query("select UE from UserEntity UE where UE.user=:user")
    public UserEntity getByUser (@Param("user") String user);
}
