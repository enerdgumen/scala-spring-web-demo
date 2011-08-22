package net.emaze.scalademo.core.device

import reflect.BeanProperty
import net.emaze.ddd.Repository
import net.emaze.addons.consumers
import net.emaze.sql.dsl._
import net.emaze.sql.dsl.Conversion.field
import net.emaze.sql.hibernate.DetachedCriteriaFactory._
import net.emaze.sql.hibernate.RichDetachedCriteria._

class HibernateDeviceService extends DeviceService {

    @BeanProperty implicit var repository: Repository = _

    override def create(network: String, ipAddress: String) = {
        val device = Device(network, ipAddress)
        repository.merge(device)
    }

    override def searchAll = {
        SELECT (*) FROM "Device"
    }

    override def findByNetworkAndIpAddress(network: String, ipAddress: String) = {
        SELECT (*) FROM "Device" WHERE "network" === network && "ipAddress" === ipAddress
    }.asList[Device].findOne
}