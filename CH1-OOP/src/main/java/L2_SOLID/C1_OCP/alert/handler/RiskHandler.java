package L2_SOLID.C1_OCP.alert.handler;

import L2_SOLID.C1_OCP.alert.AlertRule;
import L2_SOLID.C1_OCP.alert.ApiStatus;
import L2_SOLID.C1_OCP.notify.Notification;

import java.util.HashMap;
import java.util.Map;

public abstract class RiskHandler {

    protected AlertRule rule;
    protected Notification notification;

    public RiskHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void isOverhead(ApiStatus status);
}
