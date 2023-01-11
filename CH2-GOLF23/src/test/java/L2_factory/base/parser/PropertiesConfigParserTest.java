package L2_factory.base.parser;

import L2_factory.base.config.Config;
import L2_factory.base.reader.DefaultNIOFileLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/10 22:27
 */
class PropertiesConfigParserTest {
    private final PropertiesConfigParser parser = new PropertiesConfigParser(new DefaultNIOFileLoader());

    @Test
    @DisplayName("解析 properties 配置文件----正常情况1: 分隔符是 '=' ")
    void doParse_normal1() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\propertiesConfig-1.properties";
        Config parse = parser.parse(filePath);
        assertEquals("Config{configMap={sex=female, name=Zhang San, id=123456, age=12}}",parse.toString());
    }

    @Test
    @DisplayName("解析 properties 配置文件----正常情况1: 分隔符是 ':' ")
    void doParse_normal2() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\propertiesConfig-2.properties";
        Config parse = parser.parse(filePath);
        assertEquals("Config{configMap={sex=female, name=Zhang San, id=123456, age=12}}",parse.toString());
    }

    @Test
    @DisplayName("解析 properties 配置文件----异常情况1: 分隔符存在多种 ")
    void doParse_error1() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\propertiesConfig-error1.properties";
        assertThrows(RuntimeException.class,()->{
            Config parse = parser.parse(filePath);
        });
    }

    @Test
    @DisplayName("解析 properties 配置文件----异常情况1: 一种合法的分隔符都没有! ")
    void doParse_error2() {
        String filePath = "D:\\dev_projects\\1.study\\7.design-pattern\\design-partten\\CH2-GOLF23\\src\\main\\resources\\config\\propertiesConfig-error2.properties";
        assertThrows(RuntimeException.class,()->{
            Config parse = parser.parse(filePath);
        });
    }
}