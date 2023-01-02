package L3_Id_Generator;

import java.util.Date;

/**
 * @author yq
 * @version 1.0
 * @date 2023/1/2 16:52
 */
public class CommonRequest {
    private final Date date;
    private final String host;

    public CommonRequest(String host) {
        this.date = new Date();
        this.host = host;
    }

    public Date getDate() {
        return date;
    }

    public String getHost() {
        return host;
    }
}
