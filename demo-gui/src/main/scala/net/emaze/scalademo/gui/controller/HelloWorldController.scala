package net.emaze.scalademo.gui.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller

@Controller
class HelloWorldController {

    @RequestMapping(Array("/hello.html"))
    def showHello = "helloPage"
}