package demo.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystric implements HelloService {

    @Override
    public String getHello(String name) {
        return "error " + name + "not found!";
    }
}
