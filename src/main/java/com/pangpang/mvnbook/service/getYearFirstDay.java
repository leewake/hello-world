package com.pangpang.mvnbook.service;

import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Calendar;

/**
 * Created by leewake on 2017/7/28 0028.
 */
public class getYearFirstDay {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        System.out.println(currentYear);

        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        System.out.println(calendar.getTime());

    }
}
