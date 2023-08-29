package com.veo.auth.service.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Token(@JsonProperty("as_token")String asToken,@JsonProperty("as_expires_in") Long asExpiresIn,
		@JsonProperty("as_type_token") String asTypeToken,@JsonProperty("as_refresh_token") String asRefreshToken) {

}
