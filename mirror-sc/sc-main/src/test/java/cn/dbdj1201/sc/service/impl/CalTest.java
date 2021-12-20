package cn.dbdj1201.sc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: yz1201
 * @Date: 2021/10/29 10:51
 */
public class CalTest {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date parse = sdf.parse("20211031");
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(parse);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, 3);
        System.out.println(cal2.after(cal1));

    }
}
