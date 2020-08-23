package cn.dbdj1201.test.component;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-23 10:40
 */
@Component
public class IBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        System.out.println("===========begin===========");
        System.out.println("===========end===========");
    }
}
