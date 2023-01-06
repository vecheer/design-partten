package L1_singleton.c2_lazy.dcl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 12:10
 */
public class IdGenerator {
    private final AtomicLong id = new AtomicLong(0);

    private static volatile IdGenerator instance;

    private IdGenerator() {
        throw new UnsupportedOperationException("单例不允许反射创建");
    }

    public static IdGenerator getInstance(){
        if (instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
