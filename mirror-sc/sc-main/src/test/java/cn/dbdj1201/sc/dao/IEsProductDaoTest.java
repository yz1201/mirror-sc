package cn.dbdj1201.sc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:44
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IEsProductDaoTest {

    @Autowired
    private IEsProductDao productDao;

    @Test
    public void findAllProducts() {
        this.productDao.findAllProducts().forEach(System.out::println);
    }
}