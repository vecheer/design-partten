package L1_singleton.x1_thread_singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程唯一的单例模式
 * @author yq
 * @version 1.0
 * @date 2023/1/8 13:11
 */
public class IdGenerator {

    private IdGenerator() {
        throw new UnsupportedOperationException("单例类不允许手工创建!");
    }

    private final static Map<Long,IdGenerator> INSTANCE_MAP = new ConcurrentHashMap<>();

    public static IdGenerator getInstance(){
        long id = Thread.currentThread().getId();
        IdGenerator idGenerator = INSTANCE_MAP.get(id);
        if (idGenerator == null) {
            idGenerator = new IdGenerator();
            INSTANCE_MAP.put(id, idGenerator);
        }
        return idGenerator;
    }


}
