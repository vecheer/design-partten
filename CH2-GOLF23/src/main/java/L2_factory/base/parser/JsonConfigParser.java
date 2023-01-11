package L2_factory.base.parser;

import L2_factory.base.config.Config;
import L2_factory.base.parser.support.AbstractConfigParser;
import L2_factory.base.reader.support.FileLoader;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;


/**
 * 将 json 形式的 String 转化为 Config
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:45
 */
@Slf4j
public class JsonConfigParser extends AbstractConfigParser {

    public JsonConfigParser() {
    }

    public JsonConfigParser(FileLoader reader) {
        super(reader);
    }

    /**
     * 将 json 形式的 String 转化为 config
     * @param formattedString json 形式的 String
     * @return config
     */
    @Override
    protected Config doParse(String formattedString) {
        Config config = new Config();
        JSONObject jsonObject;
        try{
            jsonObject = JSON.parseObject(formattedString);
        }catch (Exception e) {
            log.error("非法的json格式! 错误信息: {}", e.getMessage());
            throw new RuntimeException("非法的json格式!");
        }
        jsonObject.forEach((k,v)->{
            config.addConfig(k,v.toString());
        });
        return config;
    }

}
