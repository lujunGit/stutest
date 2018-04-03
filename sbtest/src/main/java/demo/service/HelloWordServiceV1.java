package demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.exception.JsonResult;

@Service
public class HelloWordServiceV1 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RestTemplate restTemplate;

    @Value("${spring.application.remoteGetStock}")
    private String remoteGetStockUrl;

    public JsonResult remoteGetStock() {
        JsonResult jsonResult = restTemplate.getForObject(remoteGetStockUrl, JsonResult.class);
        logger.info("jsonResult: "+ jsonResult);
        return jsonResult;
    }
}
