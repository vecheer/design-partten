package L2_factory.base;

import com.google.common.annotations.VisibleForTesting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/8 23:46
 */
public abstract class AbstractConfigFileParser implements ConfigFileParser{
    @Override
    public Config parse(String filePath) {

        if (!checkFilePath(filePath))
            throw new IllegalArgumentException("file path [" + filePath + "] cannot be resolved!");

        String formattedString = fileToString(filePath);

        return doParse(formattedString);
    }

    private boolean checkFilePath(String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    @VisibleForTesting
    protected String fileToString(String filePath){
        StringBuilder fileContent = new StringBuilder();
        // read file
        try(FileChannel fileChannel = new FileInputStream(filePath).getChannel()){

            ByteBuffer buffer = ByteBuffer.allocateDirect(4*1024);

            while (fileChannel.read(buffer) != -1){
                // change to read
                buffer.flip();
                // read
                fileContent.append(StandardCharsets.UTF_8.decode(buffer));
                // clean
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return fileContent.toString();
    }

    protected abstract Config doParse(String formattedString);
}
