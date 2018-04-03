package demo.job.octopus;

import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import demo.Application;
import demo.exception.JsonResult;
import demo.service.HelloWordServiceV1;

public class JavaJob extends AbstractSaturnJavaJob {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public SaturnJobReturn handleJavaJob(String jobName, Integer integer, String shardParam,
            SaturnJobExecutionContext saturnJobExecutionContext) throws InterruptedException {

        logger.info("java job 定时扫描进货表开始！");
        logger.info("1:准备初始化环境...");
        ConfigurableApplicationContext evn = initEnv(new String[0]);
        logger.info("2:获取相关类bean对象...");
        HelloWordServiceV1 helloWordServiceV1 = evn.getBean(HelloWordServiceV1.class);
        JsonResult jsonResult = helloWordServiceV1.remoteGetStock();
        String stocksStr = "Octopus Java job: " + jobName + " 分片： " + shardParam + "执行完成！" + "info: " + jsonResult;
        logger.info("3:执行信息" + stocksStr);
        return new SaturnJobReturn(jsonResult.getResultData().toString());
    }

    /**
     * 环境初始化
     */
    private ConfigurableApplicationContext initEnv(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        logger.info("初始化环境完成！");
        return context;
    }

   public static void main(String[] args) throws InterruptedException {
        JavaJob javaJob = new JavaJob();
        javaJob.handleJavaJob("aa", 1, "分片1", new SaturnJobExecutionContext());
    }
}
