package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.common.dto.OrderParam;
import cn.dbdj1201.sc.component.CancelOrderSender;
import cn.dbdj1201.sc.service.IOmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-13 19:37
 */
@Service
@Slf4j
public class OmsPortalOrderServiceImpl implements IOmsPortalOrderService {

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        log.info("生成订单");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        log.info("调用取消超时订单服务");
    }

    /**
     * 取消订单
     *
     * @param orderId
     */
    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟(测试用的30秒)
        long delayTimes = 30 * 1000;
        //发送延迟消息
        log.info("发送取消超时订单的消息-{}", orderId);
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
