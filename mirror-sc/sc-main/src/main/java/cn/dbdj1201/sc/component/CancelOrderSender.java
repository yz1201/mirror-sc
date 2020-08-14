package cn.dbdj1201.sc.component;

import cn.dbdj1201.sc.common.dto.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 取消订单消息的发出者
 *
 * @Author: dbdj1201
 * @Date: 2020-08-13 19:18
 */
@Component
@Slf4j
public class CancelOrderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送订单取消的延迟消息
     *
     * @param orderId
     * @param delayTimes
     */
    public void sendMessage(Long orderId, final long delayTimes) {
        this.amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(),
                QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName(),
                orderId,
                message -> {
                    message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                    return message;
                });
        log.info("编号为{}的订单已进入取消队列，消息发送", orderId);
    }
}
