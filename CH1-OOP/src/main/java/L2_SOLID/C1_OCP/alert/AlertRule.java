package L2_SOLID.C1_OCP.alert;


import java.util.HashMap;
import java.util.Map;

public class AlertRule {

    private String name;

    private Map<String, ApiLimit> map;

    public AlertRule() {
        map = new HashMap<>();
    }

    public AlertRule(String name) {
        this.name = name;
        map = new HashMap<>();
    }

    public void addARule(String api, ApiLimit limit){
        map.put(api,limit);
    }

    public void removeRule(String api){
        map.remove(api);
    }

    public ApiLimit getMatchedRule(String api){
        ApiLimit apiLimit = map.get(api);
        if (apiLimit == null) {
            apiLimit = new ApiLimit();
        }
        return apiLimit;
    }





}
