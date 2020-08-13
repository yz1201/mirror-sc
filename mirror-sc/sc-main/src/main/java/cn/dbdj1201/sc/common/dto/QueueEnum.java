package cn.dbdj1201.sc.common.dto;

import lombok.Getter;

/**
 * 消息队列枚举配置
 *
 * @Author: dbdj1201
 * @Date: 2020-08-13 14:30
 */
@Getter
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("test.order.direct", "test.order.cancel", "test.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("test.order.direct.ttl", "test.order.cancel.ttl", "test.order.cancel.ttl");

    /**
     * 交换机名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

}
