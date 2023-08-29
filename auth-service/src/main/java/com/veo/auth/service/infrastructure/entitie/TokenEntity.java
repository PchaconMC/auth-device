package com.veo.auth.service.infrastructure.entitie;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity()
@Table(name="token")
public class TokenEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "as_token")
	String asToken;
	@Column(name = "as_expires_in")
	Long asExpiresIn;
	@Column(name = "as_type_token")
	String asTypeToken;
	@Column(name = "as_refresh_token")
	String asRefreshToken;
	@Column(name = "user_id")
	String userId;
	@Column(name="date_update")
	 LocalDateTime dateUpdate;
}
