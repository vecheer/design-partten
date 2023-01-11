package L2_factory.base.parser;

import L2_factory.base.config.Config;
import L2_factory.base.parser.support.AbstractConfigParser;
import L2_factory.base.reader.support.FileLoader;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 将 k=v 形式的 String 转化为 config
 * @author yq
 * @version 1.0
 * @date 2023/1/10 21:36
 */
@Slf4j
public class PropertiesConfigParser extends AbstractConfigParser {

    public PropertiesConfigParser() {
    }

    public PropertiesConfigParser(FileLoader reader) {
        super(reader);
    }

    /**
     * properties 文件可能使用的分隔符
     * 只允许使用 SEPARATOR 列表中罗列的分隔符
     * 分隔符一旦确定后，文件中只可存在一种分隔符，默认使用文件中第一行配置使用的分隔符，作为本文件的分隔符
     */
    private static final char[] SEPARATOR = {'=',':'};

    @Override
    protected Config doParse(String formattedString) {

        Config config = new Config();

        String[] properties = formattedString.split("\n");
        // 空文件
        if (properties.length == 0)
            return config;

        String separator = parseSeparator(properties[0]);
        for (String pvString : properties) {
            String[] kv = pvString.split(separator);
            if (kv.length != 2) {
                log.error("合法的properties配置文件中，必须且只能存在1种合法分隔符! 合法的分隔符可选是: {}",Arrays.toString(SEPARATOR));
                throw new IllegalArgumentException("合法的properties配置文件中，必须且只能存在1种合法分隔符! 合法的分隔符可选是: " + Arrays.toString(SEPARATOR));
            }

            config.addConfig(kv[0].trim(),kv[1].trim());
        }

        return config;
    }

    /**
     * 解析本配置文件中所使用的分隔符
     * 解析出来第一行配置所使用的分隔符，之后全文都默认使用该分隔符
     * @param line 配置文件中的第一行
     * @return 分隔符
     */
    public String parseSeparator(String line){
        char defaultSeparator = '$';

        char[] lineChars = line.toCharArray();
        int count = 0;

        for (char candidate : SEPARATOR) {
            for (char c : lineChars) {
                if (c == candidate) {
                    count++;
                    if (count > 1)
                        break;
                }
            }

            if (count == 1){
                defaultSeparator = candidate;
                break;
            }
        }

        if (defaultSeparator == '$'){
            log.error("合法的properties配置文件中，必须且只能存在1种合法分隔符! 合法的分隔符可选是:{}",Arrays.toString(SEPARATOR));
            throw new IllegalArgumentException("合法的properties配置文件中，必须且只能存在1种合法分隔符! 合法的分隔符可选是: " + Arrays.toString(SEPARATOR));
        }

        return defaultSeparator + "";
    }
}
