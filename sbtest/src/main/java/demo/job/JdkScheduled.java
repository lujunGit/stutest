package demo.job;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JdkScheduled {

    private static ScheduledExecutorService scheduExec;
    private long startTime;

    public JdkScheduled(){
        //final int threadNum = Runtime.getRuntime().availableProcessors() * 4;
        this.scheduExec = Executors.newScheduledThreadPool(1);
        this.startTime = System.currentTimeMillis();
    }

    public static void JdkScheduledStart(){
        JdkJob jdkJob = new JdkJob();
        //5秒中之后执行，每隔5秒执行一次
        scheduExec.scheduleAtFixedRate(jdkJob,5,10, TimeUnit.SECONDS);
    }

}
