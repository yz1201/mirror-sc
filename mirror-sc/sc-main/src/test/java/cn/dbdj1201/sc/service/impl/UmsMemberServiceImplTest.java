package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.service.IUmsMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 16:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UmsMemberServiceImplTest {

    @Autowired
    IUmsMemberService memberService;

    @Test
    public void generateAuthCode() {
        memberService.generateAuthCode("15957121194");
    }
}