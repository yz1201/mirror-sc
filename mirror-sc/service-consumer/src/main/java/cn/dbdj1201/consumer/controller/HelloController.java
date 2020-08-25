package cn.dbdj1201.consumer.controller;

import cn.dbdj1201.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-25 11:35
 */
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        this.userService.buyTicket();
        return "ok";
    }
}
