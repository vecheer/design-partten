package L1_Authentication.auth;

import com.google.common.hash.Hashing;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

public class Token {
    // 属性
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1*60*1000L;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    // 构造函数
    public Token(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }
    public Token(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    // 功能点
    public static Token createToken(String baseUrl, long createTime, String appId){
        String text = baseUrl + createTime + appId;
        String token =  Hashing.sha256().hashBytes(text.getBytes()).toString();
        return new Token(token,createTime);
    }

    public String getToken(){
        return token;
    }

    public boolean isExpired(){
        long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return ((now-createTime) > 1000);
    }

    public boolean match(Token token){
        return token.equals(token.getToken());
    }

}
