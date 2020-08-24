package cn.dbdj1201.exam.controller;


import cn.dbdj1201.exam.common.api.CommonResult;
import cn.dbdj1201.exam.entity.TbPatient;
import cn.dbdj1201.exam.service.ITbDeptService;
import cn.dbdj1201.exam.service.ITbPatientService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
@RequestMapping("/tb-patient")
@Slf4j
@Api("患者操作接口")
public class TbPatientController {

    @Autowired
    ITbPatientService patientService;

    @Autowired
    ITbDeptService deptService;

    @ApiOperation("病患挂号，保存")
    @PostMapping("/save")
    public CommonResult<String> savePatientInfo(@RequestBody TbPatient patient) {
        log.info("开始调用保存业务");
        boolean save = this.patientService.save(patient);
        log.info("保存完毕");
        if (!save) {
            return CommonResult.failed("系统繁忙，挂号失败┭┮﹏┭┮");
        }

        return CommonResult.success("挂号成功(●ˇ∀ˇ●)");
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有病患信息")
    public CommonResult<List<TbPatient>> findAllPatients() {
        log.info("开始调用查询业务");
        List<TbPatient> list = this.patientService.list();
        log.info("查询结果已出-{}", list);
        if (CollectionUtil.isEmpty(list)) {
            return CommonResult.failed("无病患信息O(∩_∩)O");
        }
        return CommonResult.success(list);
    }

    @GetMapping("/find")
    @ApiOperation("根据名称模糊查询")
    public CommonResult<TbPatient> findPatientByName(@RequestParam String name){
//        this.patientService.getOne(new QueryWrapper<>().)
        return null;
    }
}
