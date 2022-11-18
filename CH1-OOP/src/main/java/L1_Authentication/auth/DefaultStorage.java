package L1_Authentication.auth;

public class DefaultStorage implements Storage{
    @Override
    public String queryPasswordById(String appId) {
        return "123456";
    }
}
