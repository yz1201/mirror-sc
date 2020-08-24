package cn.dbdj1201.exam.controller;


import cn.dbdj1201.exam.common.api.CommonResult;
import cn.dbdj1201.exam.entity.TbDept;
import cn.dbdj1201.exam.service.ITbDeptService;
import cn.hutool.core.collection.CollectionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-24
 */
@RestController
@RequestMapping("/dept")
@Slf4j
@Api("科室Api")
public class TbDeptController {

    @Autowired
    ITbDeptService deptService;

    @GetMapping("/hello")
    public List<TbDept> findAll() {
        return this.deptService.list();
    }

    @GetMapping
    @ApiOperation("查询全部科室")
    public CommonResult<List<TbDept>> listAllDept() {
        log.info("开始调用查询业务");
        List<TbDept> list = this.deptService.list();
        log.info("查询结果已出-{}", list);
        if (CollectionUtil.isEmpty(list)) {
            return CommonResult.failed("数据库数据全丢了，88");
        }
        return CommonResult.success(list);
    }

}
