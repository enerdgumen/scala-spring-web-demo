package net.emaze.scalademo.core.device

import reflect.BeanProperty

class DeviceResponse {

    @BeanProperty var network: String = _
    @BeanProperty var ipAddress: String = _
}

object DeviceResponse {

    def apply(device: Device): DeviceResponse = {
        val response = new DeviceResponse
        response.network = device.network
        response.ipAddress = device.ipAddress
        response
    }
}