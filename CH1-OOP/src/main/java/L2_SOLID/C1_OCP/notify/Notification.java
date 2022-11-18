package L2_SOLID.C1_OCP.notify;

public class Notification {

    public void notify(NotificationEmergencyLevel level,String msg){
        throw new RuntimeException("收到["+ level.toString() +"]告警级别异常: " + msg);
    }
}
