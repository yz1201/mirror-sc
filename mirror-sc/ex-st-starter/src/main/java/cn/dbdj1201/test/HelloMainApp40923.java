package cn.dbdj1201.test;

import cn.dbdj1201.test.component.IBanner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-23 10:02
 */
@SpringBootApplication
public class HelloMainApp40923 {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HelloMainApp40923.class);
//        app.setBanner(new IBanner()); // 自定义的Banner
//        app.setBannerMode(Banner.Mode.CONSOLE); // 在控制台打印横幅
        app.run(args);
    }
}
