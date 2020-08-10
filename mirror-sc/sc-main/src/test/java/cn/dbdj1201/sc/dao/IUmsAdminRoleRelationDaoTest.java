package cn.dbdj1201.sc.dao;

import cn.dbdj1201.sc.entity.UmsPermission;
import cn.dbdj1201.sc.mapper.PmsBrandMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-10 10:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUmsAdminRoleRelationDaoTest {

    @Autowired
    private IUmsAdminRoleRelationDao adminRoleRelationDao;

//    @Autowired
//    private PmsBrandMapper brandMapper;

    @Test
    public void getPermissions() {
        List<UmsPermission> permissions = adminRoleRelationDao.getPermissions(3L);
        permissions.forEach(System.out::println);
//        brandMapper.selectList(new QueryWrapper<>()).forEach(System.out::println);
    }
}