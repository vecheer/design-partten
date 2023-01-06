package L1_singleton.c2_lazy.dcl.other;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 13:23
 */
public class Foo1 {


    private static volatile Helper helper;


    public static Helper getInstance() {
        Helper localRef = helper;
        if (localRef == null) {
            synchronized (Foo1.class) {
                localRef = helper;
                if (localRef == null) {
                    localRef = new Helper();
                    helper = localRef;
                }
            }
        }

        // 通过局部变量的方式，减少volatile变量导致的主内存的访问
        // 这个地方直接返回局部变量，而非 volatile 单例引用
        return localRef;
    }







}
