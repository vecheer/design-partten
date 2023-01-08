package L2_factory.base;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/9 0:07
 */
public class AbstractConfigFileParserTest {
    String filePath = "C:\\Users\\Administrator\\Desktop\\market_quote.txt";
    AbstractConfigFileParser defaultConfigFileParser = new AbstractConfigFileParser() {
        @Override
        protected Config doParse(String formattedString) {
            return null;
        }
    };

    @Test
    public void testReadFile(){
        String s = defaultConfigFileParser.fileToString(filePath);
        System.out.println(s);
    }
}