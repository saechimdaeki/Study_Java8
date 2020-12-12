package com.example.demo.dateAndTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAndTimeApp {
    public static void main(String[] args) throws InterruptedException {
        Date date=new Date();//date인데 타임까지 포함하고있다능...?
        long time=date.getTime();  // 이건 기계용 시간.
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000*3);
        Date after3Seconds=new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);   //mutable 하다.

        //Calendar keesunBirthDay=new GregorianCalendar(1982,7,15);  Month 는 0부터시작하므로 아래와같이 하자..
        Calendar keesunBirthDay=new GregorianCalendar(1982, Calendar.JULY,15);
        System.out.println(keesunBirthDay.getTime());


        //=======================Date와 Time API=======================
        System.out.println("=============Date와 Time API================");
        Instant instant=Instant.now(); //지금시간 (기계시간)  기준시 UTC, GMT
        System.out.println(instant);

        ZoneId zone=ZoneId.systemDefault();
        System.out.println(zone);

        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        Instant nowinst=Instant.now();

        LocalDateTime now=LocalDateTime.now(); //인류 시간 (Local이 붙어있기 때문에현재 시스템 참고해서 나옴)
        System.out.println(now);
        LocalDateTime birthday=LocalDateTime.of(1982, Month.JULY,15,0,0,0);

        ZonedDateTime nowInKorea=ZonedDateTime.now(ZoneId.of("Asia/Seoul")); //특정 zone의 시간을 보고싶을때
        System.out.println(nowInKorea);

        LocalDate today=LocalDate.now();
        LocalDate thisYearBirthday=LocalDate.of(2021,Month.FEBRUARY,15);
        Period between = Period.between(today, thisYearBirthday);
        System.out.println(between.getDays());

        Period until=today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));  //사람용 시간

        Instant plus = nowinst.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(nowinst, plus);//기계용 시간
        System.out.println(between1);

        //=============문자열 출력 위한 포매팅=====================
        System.out.println("=============문자열 출력 위한 포매팅=====================");

        LocalDateTime nowlocal=LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //포매팅
        System.out.println(now.format(MMddyyyy));


        LocalDate parse = LocalDate.parse("02/15/1994", MMddyyyy);  //파싱
        System.out.println(parse);


        Date date1=new Date();
        Instant instant1=date1.toInstant(); // 데이트 가지고 인스턴트 만들기 가능
        Date newDate=Date.from(instant1); //인스턴트 가지고 데이트 만들기 가능

        GregorianCalendar gregorianCalendar=new GregorianCalendar();
        LocalDateTime dateTime=gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // 그레고리 캘린더로 LOCALDATETIME만들기
        ZonedDateTime dateTime1=gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(dateTime1); //zonedDatetime으로 그레고리 캘린더 만들기 가능


        ZoneId zoneId= TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

    }
}
