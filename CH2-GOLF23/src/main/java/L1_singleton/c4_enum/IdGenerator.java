package L1_singleton.c4_enum;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 12:40
 */
public enum IdGenerator {
    instance;

    private final AtomicLong id = new AtomicLong(0);

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.getAndIncrement();
    }
}
