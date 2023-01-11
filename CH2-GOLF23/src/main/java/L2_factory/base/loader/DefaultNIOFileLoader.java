package L2_factory.base.loader;

import L2_factory.base.loader.support.AbstractFileLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/10 21:05
 */
public class DefaultNIOFileLoader extends AbstractFileLoader {

    @Override
    protected String doRead(String filePath) {
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

}
