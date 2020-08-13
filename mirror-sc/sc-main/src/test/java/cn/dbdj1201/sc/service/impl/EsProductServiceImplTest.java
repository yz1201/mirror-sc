package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.service.IEsProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-13 10:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EsProductServiceImplTest {

    @Autowired
    private IEsProductService esProductService;

    @Test
    public void search() {
        this.esProductService.search("海澜之家",5,5).forEach(System.out::println);
    }
}