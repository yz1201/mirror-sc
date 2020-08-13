package cn.dbdj1201.sc.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-11 14:24
 */
@Component
@Slf4j
public class OrderTimeoutCancelTask {


    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
//    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeoutOrder() {
        log.info("取消订单，并根据sku编号释放库存锁");
    }

}
