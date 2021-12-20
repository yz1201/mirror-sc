package cn.dbdj1201.sc.service;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.common.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 *
 * @Author: dbdj1201
 * @Date: 2020-08-13 19:31
 */
public interface IOmsPortalOrderService {

    /**
     * 生成订单
     *
     * @param orderParam
     * @return
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     *
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}
