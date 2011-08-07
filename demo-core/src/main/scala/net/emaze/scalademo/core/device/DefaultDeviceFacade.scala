package net.emaze.scalademo.core.device

import scala.reflect.BeanProperty
import org.springframework.transaction.annotation.Transactional
import net.emaze.logging.Logging

@Transactional
class DefaultDeviceFacade extends DeviceFacade with Logging {

    @BeanProperty
    var deviceService: DeviceService = _

    override def create(network: String, ipAddress: String) = {
        info(".create(network=%s, ipAddress=%s)", network, ipAddress)
        require(network != null, "network cannot be null")
        require(ipAddress != null, "ipAddress cannot be null")

        val device = deviceService.create(network, ipAddress)
        DeviceResponse(device)
    }

    @Transactional(readOnly = true)
    override def searchAll = {
        info(".searchAll()")
        deviceService.searchAll.map(DeviceResponse.apply)
    }
}
