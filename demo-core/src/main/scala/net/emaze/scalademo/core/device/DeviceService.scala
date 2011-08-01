package net.emaze.scalademo.core.device


trait DeviceService {

    def create(network: String, ipAddress: String): Device

    def searchAll: List[Device]

    def findByNetworkAndIpAddress(network: String, ipAddress: String): Device
}