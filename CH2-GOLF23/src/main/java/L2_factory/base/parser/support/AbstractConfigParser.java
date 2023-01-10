package L2_factory.base.parser.support;

import L2_factory.base.config.Config;
import L2_factory.base.reader.DefaultNIOFileReader;
import L2_factory.base.reader.support.FileReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:46
 */
public abstract class AbstractConfigParser implements ConfigParser {

    private final FileReader reader;

    public AbstractConfigParser() {
        this(null);
    }

    public AbstractConfigParser(FileReader reader) {
        this.reader = reader!=null?reader:new DefaultNIOFileReader();
    }

    @Override
    public Config parse(String filePath) {

        String formattedString = reader.fileToString(filePath);

        return doParse(formattedString);
    }



    protected abstract Config doParse(String formattedString);
}
