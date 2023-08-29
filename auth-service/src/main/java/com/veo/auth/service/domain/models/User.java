package com.veo.auth.service.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record User(@JsonProperty("id")String id,@JsonProperty("user")String user
		,@JsonProperty("name")String name,@JsonProperty("email")String email
		,@JsonProperty("password")String password) {
}
