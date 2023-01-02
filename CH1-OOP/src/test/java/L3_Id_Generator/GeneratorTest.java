package L3_Id_Generator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/2 17:07
 */
public class GeneratorTest {

    @Test
    public void getId() {
        System.out.println(Generator.getId(new CommonRequest("157.120.11.02")));
    }
}