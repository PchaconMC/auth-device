package com.veo.device.service.application;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.veo.device.service.domain.models.Device;
import com.veo.device.service.infrastructure.inputport.DeviceInputPort;
import com.veo.device.service.infrastructure.outputport.DeviceExternalProviderClientRest;

@Component
public class DeviceUseCase implements DeviceInputPort {

		private final Logger logger = LoggerFactory.getLogger(DeviceUseCase.class);
	
  
	   @Autowired
	   private DeviceExternalProviderClientRest deviceRest;
	   
		@Override
		public List<Device> getAll() {
				
			List<Device> device = deviceRest.deviceExternalProvider();
			return device;
		}

}
