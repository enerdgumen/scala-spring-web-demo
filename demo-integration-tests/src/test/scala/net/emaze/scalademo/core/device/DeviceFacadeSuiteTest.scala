package net.emaze.scalademo.core.device

import org.junit.{Test, Assert}
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.{ContextConfiguration, junit4}

@RunWith(classOf[junit4.SpringJUnit4ClassRunner])
@ContextConfiguration(Array(
    "/net/emaze/scalademo/conf/hibernate.spring.xml",
    "/net/emaze/scalademo/core/device/device.feature.spring.xml"
))
class DeviceFacadeSuiteTest {

    @Autowired
    var deviceFacade: DeviceFacade = _

    @Test
    def canCreateADevice {
        val device: DeviceResponse = deviceFacade.create("context", "network", "192.168.1.1")
        Assert.assertEquals("context", device.context)
    }
}
