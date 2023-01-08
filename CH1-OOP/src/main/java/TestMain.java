import java.lang.ref.SoftReference;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/6 10:53
 */
public class TestMain {
    public static void main(String[] args) {

        SoftReference<byte[]> SOFT_MEM_KILLER1 = new SoftReference<byte[]>(new byte[4*1024*1024]);
        System.out.println("4M allocated");

        SoftReference<byte[]> SOFT_MEM_KILLER2 = new SoftReference<byte[]>(new byte[4*1024*1024]);
        System.out.println("4M allocated");
        if (SOFT_MEM_KILLER1.get() == null){
            System.out.println("[2 created]1st 4M was collected");
        }


        SoftReference<byte[]> SOFT_MEM_KILLER3 = new SoftReference<byte[]>(new byte[4*1024*1024]);
        System.out.println("4M allocated");
        if (SOFT_MEM_KILLER1.get() == null){
            System.out.println("[3 created]1st 4M was collected");
        }
        if (SOFT_MEM_KILLER2.get() == null){
            System.out.println("[3 created]2nd 4M was collected");
        }

        SoftReference<byte[]> SOFT_MEM_KILLER4 = new SoftReference<byte[]>(new byte[4*1024*1024]);
        System.out.println("4M allocated");
        if (SOFT_MEM_KILLER1.get() == null){
            System.out.println("[4 created]1st 4M was collected");
        }
        if (SOFT_MEM_KILLER2.get() == null){
            System.out.println("[4 created]2nd 4M was collected");
        }
        if (SOFT_MEM_KILLER3.get() == null){
            System.out.println("[4 created]3rd 4M was collected");
        }

        System.out.println("");


        System.out.println(SOFT_MEM_KILLER1.get().length);
        System.out.println(SOFT_MEM_KILLER2.get().length);
        System.out.println(SOFT_MEM_KILLER3.get().length);
        System.out.println(SOFT_MEM_KILLER4.get().length);
    }
}
