package net.emaze.scalademo.core.device

import reflect.BeanProperty
import net.emaze.ddd.Repository
import net.emaze.consumers

class HibernateDeviceService extends DeviceService {

    @BeanProperty
    var repository: Repository = _

    override def create(network: String, ipAddress: String) = {
        val device = Device(network, ipAddress)
        repository.merge(device)
    }

    override def searchAll = {
        repository.searchAll[Device]("from Device")
    }

    override def findByNetworkAndIpAddress(network: String, ipAddress: String) = {
        repository.searchAll[Device]("from Device where network = ? and ipAddress = ?", network, ipAddress).findOne
    }
}