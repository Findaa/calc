package com.upcprovision.calc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateServices {

    @Autowired
    public DateServices() {
    }

    public Date stringToDate(String dateInString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        dateInString = "31-08-1982 10:20:56";
        Date date;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException pe) {
        date = null;
        }

        return date;
    }

    public String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    public int[] dateToArray(Date date){
        int[] i = new int[5];
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        i[0] = localDate.getYear();
        i[1] = localDate.getMonthValue();
        i[2] = localDate.getDayOfMonth();
        i[3] = localDate.getHour();
        i[4] = localDate.getMinute();
        return i;
    }

    public Date getCurrent(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return stringToDate(dateFormat.format(date));
    }

    public String getCurrentString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}
