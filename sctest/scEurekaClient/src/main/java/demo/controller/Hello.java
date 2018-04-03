package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
@ResponseBody
public class Hello {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/home/{name}")
    public String home(@PathVariable String name) {
        return "Hello " + name + " from port :" + port;
    }
}
