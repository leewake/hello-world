package com.pangpang.mvnbook.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by leewake on 2017/8/1 0001.
 */
public class TestDateFormate {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Calendar calendar = Calendar.getInstance();

        String date = dateFormat.format(calendar.getTime());

        System.out.println(date);
    }
}
