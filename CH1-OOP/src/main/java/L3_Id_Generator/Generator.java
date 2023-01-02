package L3_Id_Generator;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.UUID;

/**
 * ID 生成器
 *
 * @author yq
 * @version 1.0
 * @date 2023/1/2 16:48
 */
public class Generator {

    private static final String SEPARATOR = "-";
    private static final String DATA_FORMAT = "yyyyMMddHHmmssSSS";

    public static String getId(CommonRequest request){

        LocalDateTime ldt = LocalDateTime.ofInstant(request.getDate().toInstant(), ZoneId.systemDefault());
        String time = DateTimeFormatter.ofPattern(DATA_FORMAT).format(ldt);
        String host = request.getHost().replace(".","");
        String uuid = UUID.randomUUID().toString();

        return time + SEPARATOR + host + SEPARATOR + uuid;
    }

}
