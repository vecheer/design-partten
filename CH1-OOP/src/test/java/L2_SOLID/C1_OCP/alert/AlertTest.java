package L2_SOLID.C1_OCP.alert;


import L2_SOLID.C1_OCP.alert.handler.TimeoutCountHandler;
import L2_SOLID.C1_OCP.alert.handler.TpsHandler;
import L2_SOLID.C1_OCP.notify.Notification;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlertTest {

    Alert alert = new Alert();

    @Test
    public void check() {
        Notification notification = new Notification();

        AlertRule tpsRule = new AlertRule();
        tpsRule.addARule("user/query",new ApiLimit(1000L,null,null));
        tpsRule.addARule("user/add",new ApiLimit(500L,null,null));
        tpsRule.addARule("user/delete",new ApiLimit(500L,null,null));

        AlertRule timeoutRule = new AlertRule();
        timeoutRule.addARule("user/query",new ApiLimit(null,null,10L));
        timeoutRule.addARule("user/add",new ApiLimit(null,null,1L));
        timeoutRule.addARule("user/delete",new ApiLimit(null,null,1L));

        TpsHandler tpsHandler = new TpsHandler(tpsRule,notification);
        TimeoutCountHandler timeoutHandler = new TimeoutCountHandler(timeoutRule,notification);


        alert.addHandler(tpsHandler);
        alert.addHandler(timeoutHandler);

        try{
            alert.check(new ApiStatus(
                    "user/query",
                    1000L,
                    200L,
                    200L,
                    1
            ));
        } catch (RuntimeException e){
            assertEquals("预期收到异常时的单元测试",
                    "收到[URGENCY]告警级别异常: 当前超时数太多！",
                    e.getMessage());
        }

    }

}