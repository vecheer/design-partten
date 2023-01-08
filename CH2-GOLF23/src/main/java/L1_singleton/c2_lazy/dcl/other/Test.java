package L1_singleton.c2_lazy.dcl.other;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 15:23
 */
public class Test {

    public void func(){
        Helper instance = getHelper();
        instance.work();
    }

    public Helper getHelper(){
        return Foo1.getInstance();
    }

}
