package cn.dbdj1201.game;

import cn.hutool.core.date.DateUtil;

import java.util.Collections;
import java.util.Date;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-17 15:13
 */
public class GameRule {

    public static void main(String[] args) {
        long num = 9999999999L;
        long res = 8364436787L;
        long res2 = 8372425599L;
        System.out.println(DateUtil.date((num - res) * 1000));
        System.out.println(DateUtil.date((num - res2) * 1000));
        System.out.println(DateUtil.date(1635560824000L));

    }

}
