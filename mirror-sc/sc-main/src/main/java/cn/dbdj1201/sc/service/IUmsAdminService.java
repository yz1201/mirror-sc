package cn.dbdj1201.sc.service;

import cn.dbdj1201.sc.entity.UmsAdmin;
import cn.dbdj1201.sc.entity.UmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
public interface IUmsAdminService extends IService<UmsAdmin> {

    List<UmsPermission> getPermissions(Long umsAdminId);

    UmsAdmin register(UmsAdmin umsAdmin);

    String login(String username, String password);
}
