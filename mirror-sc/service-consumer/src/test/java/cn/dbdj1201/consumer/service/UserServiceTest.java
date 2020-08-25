package cn.dbdj1201.consumer.service;

import cn.dbdj1201.consumer.ConsumerMainApp41924;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: dbdj1201
 * @Date: 2020-08-25 11:27
 */
@SpringBootTest(classes = ConsumerMainApp41924.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void buyTicket() {
        this.userService.buyTicket();
    }
}