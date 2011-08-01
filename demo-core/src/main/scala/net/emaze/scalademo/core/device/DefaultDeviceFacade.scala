package net.emaze.scalademo.core.device

import scala.reflect.BeanProperty
import org.springframework.transaction.annotation.Transactional
import net.emaze.scalademo.core.{dbc, Logging}

@Transactional
class DefaultDeviceFacade extends DeviceFacade with Logging {

    @BeanProperty
    var deviceService: DeviceService = _
    
    override def create(network: String, ipAddress: String) = {
        info(".create(network=%s, ipAddress=%s)", network, ipAddress)
        dbc.precondition(network != null, "network cannot be null")
        dbc.precondition(ipAddress != null, "ipAddress cannot be null")
        
        val device = deviceService.create(network, ipAddress)
        DeviceResponse(device)
    }

    override def searchAll = {
        info(".searchAll()")
        deviceService.searchAll.map(DeviceResponse.apply)
    }
}
