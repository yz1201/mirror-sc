package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.service.IUmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-10 13:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UmsAdminServiceImplTest {
    @Autowired
    private IUmsAdminService umsAdminService;

    @Test
    public void login() {
        System.out.println(this.umsAdminService.login("admin", "$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO"));
    }
}