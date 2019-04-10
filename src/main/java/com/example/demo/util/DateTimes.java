package com.example.demo.util;

import java.util.Date;

/**
 */
public class DateTimes {

    public static final String datetimeStyle = "MM-dd-yyyy HH:mm:ss";

    public static Date parse(String dateStr, String pattern){
        // parse(dateStr, datetimeStyle);
        return null;
    }

    private static Date parse(String dateStr, String[] patterns) {
        try {
            if (dateStr != ""&& dateStr.length() > 19) {
                dateStr = dateStr.substring(0, 19);
            }

            //fix: 通过表单拼接的时间格式，中间的空格有问题，先替换 at 2016-04-26
            dateStr = dateStr.replace(" ", " "); //注：两个空格不同

            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
}
