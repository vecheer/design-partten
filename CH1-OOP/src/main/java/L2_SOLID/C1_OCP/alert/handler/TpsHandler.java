package L2_SOLID.C1_OCP.alert.handler;

import L2_SOLID.C1_OCP.alert.AlertRule;
import L2_SOLID.C1_OCP.alert.ApiStatus;
import L2_SOLID.C1_OCP.notify.Notification;
import L2_SOLID.C1_OCP.notify.NotificationEmergencyLevel;

import java.util.HashMap;
import java.util.Map;

public class TpsHandler extends RiskHandler {

    private final Map<String, AlertRule> tpsTable = new HashMap<>();

    public TpsHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void isOverhead(ApiStatus status) {
        long tps = status.getRequestCount() / status.getDurationOfSeconds();
        if  (tps > rule.getMatchedRule(status.getApi()).getMaxTps())
            notification.notify(NotificationEmergencyLevel.URGENCY, "当前 tps 过载！");
    }
}
