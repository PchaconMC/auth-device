package com.veo.auth.service.infrastructure.entitie;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity()
@Table(name="users")
public class UserEntity {
	@Id
	String id;
	@Column(name = "users")
	String user;
	String name;
	String email;
	@Column(name="date_update")
	 LocalDateTime dateUpdate;
}
