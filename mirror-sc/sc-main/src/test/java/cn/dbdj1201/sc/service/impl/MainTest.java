package cn.dbdj1201.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yz1201
 * @Date: 2021/8/19 9:16
 */
public class MainTest {
    public static void main(String[] args) {
        String s = "afaf.as";
        s.split(".");

//        System.out.println("sad0".equals(null));

//        System.out.println(Double.valueOf(""));

        List<Double> doubles = new ArrayList<>();
        doubles.add(2.622);
        doubles.add(3.622);
        doubles.add(2.622);
        doubles.add(1.622);
        System.out.println(doubles);
        doubles.sort((d1, d2) -> {
            if (d1 > d2) {
                return 1;
            } else if (d1 < d2) {
                return -1;
            }
            return 0;
        });
        System.out.println(doubles);
    }
}
