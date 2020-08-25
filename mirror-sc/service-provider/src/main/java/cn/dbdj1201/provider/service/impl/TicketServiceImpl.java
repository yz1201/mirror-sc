package cn.dbdj1201.provider.service.impl;

import cn.dbdj1201.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-25 11:13
 */
@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return " hello dubbo ";
    }
}
