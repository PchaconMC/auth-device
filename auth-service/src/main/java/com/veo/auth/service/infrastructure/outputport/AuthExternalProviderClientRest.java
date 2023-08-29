package com.veo.auth.service.infrastructure.outputport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veo.auth.service.domain.models.Token;


@FeignClient(name="external-auth", url="3be59b9c-04aa-4c3d-8951-b33f478be9fe.mock.pstmn.io")
public interface AuthExternalProviderClientRest {
	
	
	@GetMapping("/login")
	public Token loginExternalProvider( @RequestParam("user") String user,  @RequestParam("password") String password);
}
