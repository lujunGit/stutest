package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    private static ConfigurableApplicationContext context = null;

    public ApplicationTest(){
        context = initEvn(new String[0]);
    }

    private static ConfigurableApplicationContext initEvn(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        return context;
    }

}
