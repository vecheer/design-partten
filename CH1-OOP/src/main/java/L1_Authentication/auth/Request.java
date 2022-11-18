package L1_Authentication.auth;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public Request() {
    }

    public Request(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static Request parseFromRawUrl(String url){
        Map<String,String> map = new HashMap<>();

        // 约定好识别的url固定是：xxxxxxx?appId=A&token=B&ts=T;
        String baseUrlPart = url.substring(0,url.indexOf("?"));
        String paramPart = url.substring(url.indexOf("?"));
        String[] params = paramPart.split("&");
        for (String param : params) {
            String[] kv = param.split("=");
            map.put(kv[0],kv[1]);
        }
        return new Request(baseUrlPart,map.get("token"),map.get("appId"),Long.parseLong(map.get("ts")));
    }
    public String getBaseUrl() {
        return baseUrl;
    }
    public String getToken() {
        return token;
    }
    public String getAppId() {
        return appId;
    }
    public long getTimestamp() {
        return timestamp;
    }
}
