package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main( String[] args )
    {
        logger.info("Application is ready run...");
        SpringApplication.run(Application.class, args);
        logger.info("Application is running...");
        //定时任务调度
        InitData.initRun();
    }

    @Bean
    public RestTemplate loadRestTemplate() {
        return new RestTemplate();
    }

}
