package demo.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import demo.model.Stock;

public class CacheData {

    private static Map<String,Stock> localCacheStock = new ConcurrentHashMap<String,Stock>();

    public static Map<String,Stock> getLocalCacheStock(){
        return localCacheStock;
    }
}
