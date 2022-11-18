package L2_SOLID.C1_OCP.alert.handler;

import L2_SOLID.C1_OCP.alert.AlertRule;
import L2_SOLID.C1_OCP.alert.ApiStatus;
import L2_SOLID.C1_OCP.notify.Notification;
import L2_SOLID.C1_OCP.notify.NotificationEmergencyLevel;

public class TimeoutCountHandler extends RiskHandler{

    public TimeoutCountHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void isOverhead(ApiStatus status) {
        if (status.getTimeoutCount() > rule.getMatchedRule(status.getApi()).getMaxTimeoutCount())
            notification.notify(NotificationEmergencyLevel.URGENCY, "当前超时数太多！");
    }
}
