package L1_singleton.c2_lazy.classlock;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * 懒汉式
 * 支持懒加载
 *
 * @author yq
 * @version 1.0
 * @date 2023/1/6 12:07
 */

public class IdGenerator {
    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private IdGenerator() {}

    // 第一次 getInstance 时才会加载
    // 线程不安全
    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}