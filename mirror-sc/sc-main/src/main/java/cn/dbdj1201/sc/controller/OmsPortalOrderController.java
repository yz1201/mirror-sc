package cn.dbdj1201.sc.controller;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.common.dto.OrderParam;
import cn.dbdj1201.sc.service.IOmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-14 9:28
 */
@RestController
@Slf4j
@Api("OmsPortalOrderController")
@RequestMapping("/order")
public class OmsPortalOrderController {

    @Autowired
    private IOmsPortalOrderService orderService;

    @PostMapping("/generate")
    @ApiOperation("生成订单号")
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        return this.orderService.generateOrder(orderParam);
    }

}
