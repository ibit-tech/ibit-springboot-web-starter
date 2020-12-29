package tech.ibit.web.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author iBit程序猿
 */
public class DateUtils {

    private DateUtils() {
    }

    /**
     * 格式化时间
     *
     * @param date    时间
     * @param pattern 格式
     * @return 格式化后的时间
     */
    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
