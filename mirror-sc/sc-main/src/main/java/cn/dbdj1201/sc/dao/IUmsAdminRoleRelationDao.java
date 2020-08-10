package cn.dbdj1201.sc.dao;

import cn.dbdj1201.sc.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-10 9:44
 * 自定义DAO
 */
public interface IUmsAdminRoleRelationDao {

    /**
     *
     * @param umsAdminId
     * @return
     */
    List<UmsPermission> getPermissions(@Param("umsAdminId") Long umsAdminId);
}
