package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.service.HelloService;

@RestController
@RequestMapping("v1")
@ResponseBody
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello/{name}")
    public String getHello(@PathVariable String name){
        return helloService.getHello(name);
    }
}
