package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Hello {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/home/{name}")
    public String home(@PathVariable String name) {

        return "Hello " + name + " getFoo is : " + foo;
    }
}
