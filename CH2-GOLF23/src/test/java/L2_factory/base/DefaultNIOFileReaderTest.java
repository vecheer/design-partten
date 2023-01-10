package L2_factory.base;

import L2_factory.base.reader.DefaultNIOFileReader;
import L2_factory.base.reader.support.FileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/9 0:07
 */
public class DefaultNIOFileReaderTest {
    String filePath = "C:\\Users\\Administrator\\Desktop\\market_quote.txt";
    FileReader reader = new DefaultNIOFileReader();

    @Test
    @DisplayName("NIO 读取文件")
    public void testReadFile(){
        String s = reader.fileToString(filePath);
        System.out.println(s);
    }
}