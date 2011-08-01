package net.emaze.scalademo.core.device

trait DeviceFacade {
    
    def create(network: String, ipAddress: String): DeviceResponse

    def searchAll: List[DeviceResponse]
}
