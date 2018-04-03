package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import demo.exception.BaseException;
import demo.exception.JsonResult;
import demo.exception.RespCode;
import demo.model.Stock;
import demo.model.User;
import demo.cache.CacheData;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.remoteGetIndexUrl}")
    private String remoteGetIndexUrl;

    @RequestMapping("/index/{name}")
    @ResponseBody
    public JsonResult index(HttpServletRequest request, @PathVariable String name) {
        JsonResult jsonResult = new JsonResult(request.getRequestURI());
        if (StringUtils.isEmpty(name)) {
            logger.info("log is info lever");
            throw new BaseException(RespCode.PARAMETER_ERROR);//这种方式写在实现层
        }
        if (name.equals("aa")) {
            logger.debug("log is debug lever");
            throw new BaseException(RespCode.REQUEST_ERROR);
        }
        if (name.equals("bb")) {
            logger.warn("log is warn lever");
            throw new BaseException(RespCode.NULL_POINT);
        }
        jsonResult.setRespCode(RespCode.SUCCESS);
        jsonResult.setResultData(User.getUsers());
        return jsonResult;
    }

    @RequestMapping("/version")
    public String getProjectVersion() {
        if (env != null) {
            String description = env.getProperty("spring.application.description");
            String version = env.getProperty("spring.application.version");
            System.out.print(description + version);
            return version;
        }
        return null;
    }

    @RequestMapping("/home")
    public String home() {
        try {
            throw new Exception("sss");
        } catch (Exception e) {
            System.out.print("print Exception!");
        }
        return "index";
    }

    @RequestMapping("/remoteGetIndex/{name}")
    public JsonResult remoteGetIndex(@PathVariable String name) {
        JsonResult jsonResult = restTemplate.getForObject(remoteGetIndexUrl + name, JsonResult.class);
        logger.info("jsonResult: "+ jsonResult);
        return jsonResult;
    }

    @RequestMapping("/getStock")
    public JsonResult getStock(HttpServletRequest request){
        Map<String, Stock> stockCache = CacheData.getLocalCacheStock();
        JsonResult jsonResult = new JsonResult(request.getRequestURI());
        Map<String, Stock> stockMap= null;
        List<Map<String, Stock>> stocks = new ArrayList<Map<String, Stock>>(stockCache.size() + 1);
        //Stock stock = null;
        try {
            for (Map.Entry<String, Stock> entry : stockCache.entrySet()) {
                Stock stock = (Stock) entry.getValue();
                if(stock!=null && !stock.getSync()) {
                    stockMap = new HashMap<String, Stock>();
                    stockMap.put(entry.getKey(),stock);
                    stocks.add(stockMap);
                }
            }
            jsonResult.setRespCode(RespCode.SUCCESS);
        }catch(Exception e){
            jsonResult.setRespCode(RespCode.UNKNOWN_ERROR);
            jsonResult.setResultMsg(RespCode.UNKNOWN_ERROR.getResMsg() + e.getMessage());
        }
        jsonResult.setResultData(stocks);
        List a = new ArrayList();
        Set s = new HashSet();
        Map h = new HashMap();
        return jsonResult;
    }

}
