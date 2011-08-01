package net.emaze.scalademo.core.device

import reflect.BeanProperty
import net.emaze.ddd.Repository
import net.emaze.collections.Consumers

class HibernateDeviceService extends DeviceService {

    @BeanProperty
    var repository: Repository = _

    override def create(network: String, ipAddress: String) = {
        val device = Device(network, ipAddress)
        repository.merge(device)
    }

    override def searchAll = {
        repository.search[Device]("from Device")
    }

    override def findByNetworkAndIpAddress(network: String, ipAddress: String) = {
        val devices = repository.search[Device]("from Device where network = ? and ipAddress = ?", network, ipAddress)
        Consumers.one(devices)
    }
}