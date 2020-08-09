package cn.dbdj1201.sc.service;

import cn.dbdj1201.sc.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
public interface IUmsMemberService extends IService<UmsMember> {

    String generateAuthCode(String phoneNumber);

    boolean verify(String authCode, String phoneNumber);
}
