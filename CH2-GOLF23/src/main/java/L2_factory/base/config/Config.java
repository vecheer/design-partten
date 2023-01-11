package L2_factory.base.config;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 配置存储
 *
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:39
 */
public final class Config {

    private final Map<String,String> configMap = new HashMap<>();

    public String getConfig(String key){
        assert key != null : "the key to query config cannot be null";
        return configMap.get(key);
    }

    public void addConfig(String key, String value) {
        assert key != null : "the key of config cannot be null";
        configMap.put(key, value);
    }

    public boolean containsConfig(String key){
        assert key != null : "the key to query config cannot be null";
        return configMap.containsKey(key);
    }

    @Override
    public String toString() {
        return "Config{" +
                "configMap=" + configMap +
                '}';
    }
}
