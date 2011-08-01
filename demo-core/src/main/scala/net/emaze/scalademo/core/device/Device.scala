package net.emaze.scalademo.core.device

import scala.reflect.BeanProperty

class Device {
    
    @BeanProperty var id: Int = _
    @BeanProperty var network: String = _
    @BeanProperty var ipAddress: String = _
}

object Device {

    def apply(network: String, ipAddress: String): Device = {
        val device = new Device
        device.network = network
        device.ipAddress = ipAddress
        device
    }
}