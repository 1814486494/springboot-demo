package com.springboot.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author:linwenfeng
 * @Time:2020/10/29 14:21
 */
public class DateUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    //时间格式转换
    public static String dateFormat(Date date){
        return simpleDateFormat.format(date);
    }

    //LocalDateTime转换为Date
    public static Date localDateTime2Date(LocalDateTime localDateTime){
       return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    //已有时间增加天数，返回Date
    public static Date localDateTimePlusDays(LocalDateTime localDateTime,Long days){
        return localDateTime2Date(localDateTime.plusDays(days));
    }

    //已有时间减少天数，返回Date
    public static Date localDateTimeMinusDays(LocalDateTime localDateTime,Long days){
        return localDateTime2Date(localDateTime.plusDays(days));
    }

    //已有时间增加分钟，返回Date
    public static Date localDateTimePlusMin(LocalDateTime localDateTime,Long min){
        return localDateTime2Date(localDateTime.plusMinutes(min));
    }

}
