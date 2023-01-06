package L1_singleton.c3_innerclass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 12:25
 */
public class IdGenerator {
    private final AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
        throw new UnsupportedOperationException("单例不允许反射创建");
    }

    private static class InnerClass {
        private final static IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return InnerClass.instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
