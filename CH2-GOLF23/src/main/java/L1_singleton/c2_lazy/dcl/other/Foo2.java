package L1_singleton.c2_lazy.dcl.other;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 13:23
 */
public class Foo2 {
    private static volatile Helper helper;


    public static Helper getInstance() {
        if (helper == null) {
            synchronized (Foo2.class) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }




















}
