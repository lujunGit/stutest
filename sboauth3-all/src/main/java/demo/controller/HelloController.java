package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/v1")
public class HelloController {

    @RequestMapping("/user")
    public Principal getUser(Principal principal){
        return principal;
    }
}
