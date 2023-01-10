package L2_factory.base.parser.support;

import L2_factory.base.config.Config;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:37
 */
public interface ConfigParser {

    Config parse(String filePath);


}
