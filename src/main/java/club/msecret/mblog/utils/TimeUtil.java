package club.msecret.mblog.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public Long transferStampToArticleId(String stamp) {
        String time = new SimpleDateFormat("YYMMddHHmmss").format(Long.parseLong(stamp));
        return Long.parseLong(time);
    }

    public LocalDateTime transferStampToTime(String stamp) {
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(Long.parseLong(stamp));
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
