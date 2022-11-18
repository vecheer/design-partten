package L2_SOLID.C1_OCP.alert.handler;

import L2_SOLID.C1_OCP.alert.AlertRule;
import L2_SOLID.C1_OCP.alert.ApiStatus;
import L2_SOLID.C1_OCP.notify.Notification;
import L2_SOLID.C1_OCP.notify.NotificationEmergencyLevel;

public class ErrorCountHandler extends RiskHandler {

    public ErrorCountHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void isOverhead(ApiStatus status) {
        if  (status.getErrorCount() > rule.getMatchedRule(status.getApi()).getMaxErrorCount())
            notification.notify(NotificationEmergencyLevel.SEVERE, "当前错误数太多!");
    }
}
