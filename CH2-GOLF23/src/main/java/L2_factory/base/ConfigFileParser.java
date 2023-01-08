package L2_factory.base;

import java.io.InputStream;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:37
 */
public interface ConfigFileParser {

    Config parse(String filePath);


}
