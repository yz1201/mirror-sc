package cn.dbdj1201.consumer.service;

import cn.dbdj1201.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-25 11:25
 */
@Service
public class UserService {
    @Reference //远程引用指定的服务，他会按照全类名进行匹配，看谁给注册中心注册了这个全类名
    private TicketService ticketService;

    public void buyTicket() {
        String ticket = this.ticketService.getTicket();
        System.out.println("在注册中心买到" + ticket);
    }
}
