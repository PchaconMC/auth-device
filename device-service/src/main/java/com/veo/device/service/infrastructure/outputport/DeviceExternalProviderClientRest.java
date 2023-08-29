package com.veo.device.service.infrastructure.outputport;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.veo.device.service.domain.models.Device;

@FeignClient(name="external-device", url="3be59b9c-04aa-4c3d-8951-b33f478be9fe.mock.pstmn.io")
public interface DeviceExternalProviderClientRest {
	@GetMapping("/dispositivosRegistrados")
	public List<Device> deviceExternalProvider( );
}
