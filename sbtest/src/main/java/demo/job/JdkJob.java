package demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import demo.model.Stock;
import demo.cache.CacheData;
import demo.util.TimeUtil;

public class JdkJob implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Stock> localCacheData = CacheData.getLocalCacheStock();

    private static String batchNum = null;

    private static final String stockName = "admin";

    @Override
    public void run() {
        batchNum = UUID.randomUUID().toString();
        logger.info("jdk job 批次 " + batchNum + " 生成成功, -- " + demo.util.TimeUtil.ymdHms2str() + "\n");
        Long startTime = System.currentTimeMillis();
        if (localCacheData.size() == 100 || localCacheData.size() > 100) {
            logger.info("已经超出100条，自动退出！时间： " + TimeUtil.ymdHms2str());
            return;
        } else {
            for (int i = 0; i < 10; i++) {
                localCacheData
                        .put("stock-[" + batchNum + "]-" + i, new Stock(Long.valueOf(i), 100L, stockName, new Date(),
                                null,
                                false));
            }
            Long endTime = System.currentTimeMillis();
            logger.info("定时数据生成成功，用时 " + (endTime - startTime) / 1000 + " 当前总数据量为：" + localCacheData.size() + " 条。");
        }
    }
}
