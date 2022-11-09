package com.ZenPack.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Component
public class CommonFunctions {
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    JdbcTemplate jdbc;
//    private List<String> dateFormats = Arrays.asList("MM-dd-yyyy HH:mm:ss mm-dd-yyyy HH:mm:ss".split(","));

//    public String getCurrentDateWithTime() {
//        String currentTime = "";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        currentTime = dtf.format(now);
//        return currentTime;
//    }

//    public String convertToUtc(TimeZone timeZone, String dateString) throws ParseException {
//        String utcTime = dateString;
//        String df = "yyyy/MM/dd HH:mm:ss";
//        if (dateString != null && dateString.contains("-")) {
//            df = "yyyy-MM-dd HH:mm:ss";
//        }
//        DateFormat formatterIST = new SimpleDateFormat(df);
//        formatterIST.setTimeZone(TimeZone.getDefault()); // better than using IST
//        if (dateString != null && !dateString.isEmpty()) {
//            Date date = formatterIST.parse(dateString);
//
//            DateFormat formatterUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC timezone
//            return formatterUTC.format(date);
//        }
//        return utcTime;
//    }

    public String getUtcDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now(Clock.systemUTC());
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate.toString();
    }
}
