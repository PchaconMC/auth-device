package com.veo.device.service.infrastructure.adapters.in;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veo.device.service.domain.models.Device;
import com.veo.device.service.infrastructure.inputport.DeviceInputPort;


@RestController
@RequestMapping(value = "/")
public class DeviceAPI {
	
	@Autowired
    DeviceInputPort deviceInputPort;

	@GetMapping("list")
    public List<Device> getregisteredDevices(  ) {
        return deviceInputPort.getAll();
        }
}
