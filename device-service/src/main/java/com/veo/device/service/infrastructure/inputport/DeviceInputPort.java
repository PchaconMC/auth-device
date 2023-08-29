package com.veo.device.service.infrastructure.inputport;

import java.util.List;

import com.veo.device.service.domain.models.Device;

public interface DeviceInputPort {

	public List<Device> getAll();
}
