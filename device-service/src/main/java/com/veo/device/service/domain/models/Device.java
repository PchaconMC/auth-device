package com.veo.device.service.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Device(@JsonProperty("id")Long id,@JsonProperty("name") String name,
		@JsonProperty("user_id") String userId,@JsonProperty("ip") String ip) {

}
