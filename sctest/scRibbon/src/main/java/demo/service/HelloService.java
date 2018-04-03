package demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private RestTemplate restTemplate;

    @Value("${spring.application.helloUrl}")
    private String helloUrl;

    @Autowired
    public HelloService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "hiError")
    public String getHello(String name) {
        try {
            return restTemplate.getForObject(helloUrl + name, String.class);
        } catch (Exception e) {
            return "error " + e.getMessage();
        }
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
