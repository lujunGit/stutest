package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import demo.model.AuthTokenInfo;
import demo.model.HttpUtil;

public class Test {

    private static Logger log = LoggerFactory.getLogger(Test.class);

    public static final String REST_SERVICE_URI = "http://127.0.0.1:8081/";

    public static final String AUTH_SERVER_URI = "http://127.0.0.1:8081/oauth/token";

    public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=user&password=password";

    public static final String QPM_ACCESS_TOKEN = "?access_token=";

    @SuppressWarnings({"unchecked", "rawtypes"})
    /*private static void listAllUsers(AuthTokenInfo tokenInfo) {
        Assert.notNull(tokenInfo, "Authenticate first please......");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        String response = restTemplate.postForObject(String.format(REST_SERVICE_URI + "/api/get/%s" + QPM_ACCESS_TOKEN +
                tokenInfo.getAccess_token(),"dajun"),request,String.class);
        log.info(response);
    }*/

    public static void main(String args[]) {
        String getTokenUrl = AUTH_SERVER_URI + QPM_PASSWORD_GRANT;
        String requestUrl = REST_SERVICE_URI + "/api/get/%s" + QPM_ACCESS_TOKEN;
        String clientId = "acme";
        String secret = "acmesecret";
        RestTemplate restTemplate = new RestTemplate();
        String token = HttpUtil.getToken(restTemplate, getTokenUrl, clientId, secret);
        log.info(token);

        HttpEntity<String> request = new HttpEntity<String>(HttpUtil.getHeaders());
        String result = restTemplate.postForObject(requestUrl + token, request, String.class);
        log.info(result);
    }
}
