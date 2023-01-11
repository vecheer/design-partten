package L2_factory.base.parser;

import L2_factory.base.config.Config;
import L2_factory.base.reader.DefaultNIOFileLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/10 22:10
 */
class JsonConfigParserTest {

    private final JsonConfigParser parser = new JsonConfigParser(new DefaultNIOFileLoader());

    @Test
    @DisplayName("解析 json 配置文件----正常情况")
    void doParse_normal() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\jsonConfig.json";
        Config parse = parser.parse(filePath);
        assertEquals("Config{configMap={sex=female, name=Zhang San, id=123456, age=12}}",parse.toString());
    }

    @Test
    @DisplayName("解析 json 配置文件----错误情况: 配置文件中是个非法的json格式")
    void doParse_error() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\jsonConfig-error.json";

        assertThrows(RuntimeException.class,()->{
            Config parse = parser.parse(filePath);
        });
    }
}