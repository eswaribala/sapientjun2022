package com.sapient.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class TimeAPIDemo {
    public static void main(String[] args){

        LocalTime indiaLocalTime= LocalTime.now();
        System.out.println(indiaLocalTime.toString());
        //print current time in London or Australia etc.,
        LocalTime localTime=null;
        for(String zoneId: ZoneId.getAvailableZoneIds()){
            localTime=LocalTime.now(ZoneId.of(zoneId));
            System.out.println("Zone Id"+zoneId+"--->Current Time is--->"
                    +localTime.toString()+"--->Time Difference with IST--->"
                    + ChronoUnit.HOURS.between(indiaLocalTime, localTime));
        }
        Period period = Period.of(1, 6,29);
        System.out.println(LocalDate.now().plus(period));

    }


}
