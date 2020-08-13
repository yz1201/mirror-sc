package cn.dbdj1201.sc.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-13 19:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderParam implements Serializable {
    //收获地址id
    private Long memberReceiveAddressId;
    //优惠券ID
    private Long couponId;
    //使用积分
    private Integer useIntegration;
    //支付类型
    private Integer payType;
}
