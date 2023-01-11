package L2_factory.base.loader.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/10 20:42
 */
public abstract class AbstractFileLoader implements FileLoader {

    private static final Logger log = LoggerFactory.getLogger(AbstractFileLoader.class);

    @Override
    public String fileToString(String filePath) {
        checkExists(filePath);
        return doRead(filePath);
    }

    private void checkExists(String filePath){
        Path path = Paths.get(filePath);
        boolean isExist = Files.exists(path);
        if (!isExist){
            log.error("待读取的文件{}不存在",filePath);
            throw new IllegalArgumentException("filePath: " + filePath + "解析失败，该文件不存在!");
        }
    }

    protected abstract String doRead(String filePath);
}
