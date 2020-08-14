package cn.dbdj1201.sc.component;

import cn.dbdj1201.sc.service.IOmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-13 19:27
 */
@Component
@RabbitListener(queues = "test.order.cancel")
@Slf4j
public class CancelOrderReceiver {

    @Autowired
    private IOmsPortalOrderService orderService;

    @RabbitListener
    public void handel(Long orderId) {
        log.info("receive delay message orderId:{}", orderId);
        this.orderService.cancelOrder(orderId);
    }
}
