package com.lxy.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter[] dateTimeFormatters = new DateTimeFormatter[]{
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL),
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
                DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")
        };

        LocalDateTime time = LocalDateTime.now();

        for(DateTimeFormatter formatter : dateTimeFormatters){
            System.out.println(time.format(formatter));
        }

    }
}
