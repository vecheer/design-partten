package L3_Id_Generator;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
    private static final int RANDOM_LENGTH = 15;

    private static final char[] CHAR_TABLE = {
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z',

            '0','1','2','3','4','5','6','7','8','9',

            'A','B','C','D','E','F','G','H','I','J','K',
            'L','M','N','O','P','Q','R','S','T','U',
            'V','W','X','Y','Z'
    };

    public static String getId(CommonRequest request){

        LocalDateTime ldt = LocalDateTime.ofInstant(request.getDate().toInstant(), ZoneId.systemDefault());
        String time = DateTimeFormatter.ofPattern(DATA_FORMAT).format(ldt);
        String host = request.getHost().replace(".","");
        String randomId = randomStr(RANDOM_LENGTH);

        return time + SEPARATOR + host + SEPARATOR + randomId;
    }


    private static String randomStr(int length){
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * CHAR_TABLE.length);
            result.append(CHAR_TABLE[random]);
        }
        return result.toString();
    }
}
