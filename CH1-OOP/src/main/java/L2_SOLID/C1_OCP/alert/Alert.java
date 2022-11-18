package L2_SOLID.C1_OCP.alert;

import L2_SOLID.C1_OCP.alert.handler.RiskHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 告警类
 * 目前拥有的功能：
 * - 一段时间内的访问量（tps）
 * - 一段时间内的错误数
 *
 * - 可以添加自定义的告警和处理
 */

public class Alert {
    private Map<Class<?>, RiskHandler> handlerMap;

    public Alert() {
        this.handlerMap = new HashMap<>();;
    }

    private RiskHandler getHandler(Class<?> handlerType){
        return handlerMap.get(handlerType);
    }


    public void addHandler(RiskHandler riskHandler){
        handlerMap.put(riskHandler.getClass(), riskHandler);
    }

    public void removeHandler(RiskHandler riskHandler){
        handlerMap.remove(riskHandler.getClass());
    }


    public void check(ApiStatus status){
        handlerMap.forEach((k,v)->{
            v.isOverhead(status);
        });

    }
}