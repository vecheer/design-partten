package L1_singleton.c1_hungry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author yq
 * @version 1.0
 * @date 2023/1/6 12:07
 */
public class IdGenerator {

    private final AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
