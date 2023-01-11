package L2_factory.base;

import L2_factory.base.reader.DefaultNIOFileLoader;
import L2_factory.base.reader.support.FileLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/9 0:07
 */
public class DefaultNIOFileLoaderTest {
    String filePath = "C:\\Users\\Administrator\\Desktop\\market_quote.txt";
    FileLoader reader = new DefaultNIOFileLoader();

    @Test
    @DisplayName("NIO 读取文件")
    public void testReadFile(){
        String s = reader.fileToString(filePath);
        System.out.println(s);
    }
}