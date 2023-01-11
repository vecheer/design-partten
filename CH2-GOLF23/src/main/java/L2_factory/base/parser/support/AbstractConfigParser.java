package L2_factory.base.parser.support;

import L2_factory.base.config.Config;
import L2_factory.base.reader.DefaultNIOFileLoader;
import L2_factory.base.reader.support.FileLoader;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:46
 */
public abstract class AbstractConfigParser implements ConfigParser {

    private final FileLoader loader;

    public AbstractConfigParser() {
        this(null);
    }

    public AbstractConfigParser(FileLoader reader) {
        this.loader = reader!=null?reader:new DefaultNIOFileLoader();
    }

    @Override
    public Config parse(String filePath) {

        String formattedString = loader.fileToString(filePath);

        return doParse(formattedString);
    }



    protected abstract Config doParse(String formattedString);
}
