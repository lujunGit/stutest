package demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="scEurekaClient",fallback = HelloServiceHystric.class)
public interface HelloService {

    @RequestMapping("/v1/home/{name}")
    String getHello(@PathVariable String name);
}
