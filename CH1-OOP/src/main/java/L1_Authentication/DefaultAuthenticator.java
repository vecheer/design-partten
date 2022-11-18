package L1_Authentication;

import L1_Authentication.auth.DefaultStorage;
import L1_Authentication.auth.Request;
import L1_Authentication.auth.Storage;
import L1_Authentication.auth.Token;

import javax.annotation.Resource;

public class DefaultAuthenticator implements Authenticator{

    @Resource
    Storage storage;

    @Override
    public void auth(String restUrl) {
        Request restRequest = Request.parseFromRawUrl(restUrl);
        auth(restRequest);
    }

    @Override
    public void auth(Request request) {
        String tokenString = request.getToken();
        long timestamp = request.getTimestamp();
        String appId = request.getAppId();

        Token clientToken = new Token(tokenString,timestamp);
        if (clientToken.isExpired()) {
            throw new RuntimeException("token is expired!");
        }

        String password = storage.queryPasswordById(appId);
        Token serverToken = Token.createToken(request.getBaseUrl(), request.getTimestamp(), request.getAppId());

        if (!serverToken.match(clientToken)){
            throw new RuntimeException("token not match!");
        }
    }
}
