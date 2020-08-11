package cn.dbdj1201.sc.controller;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.nosql.mongodb.document.MemberReadHistory;
import cn.dbdj1201.sc.service.IMemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员商品浏览管理Controller
 *
 * @Author: dbdj1201
 * @Date: 2020-08-11 16:34
 */
@RestController
@Slf4j
@Api("MemberReadHistoryController")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private IMemberReadHistoryService memberReadHistoryService;


    @ApiOperation("增加浏览记录")
    @PostMapping("/create")
    public CommonResult<Object> createReadHistory(@RequestBody MemberReadHistory readHistory) {
        log.info("新增记录");
        int count = this.memberReadHistoryService.create(readHistory);
        if (count == 0) {
            log.warn("新增失败");
            return CommonResult.failed();
        }
        return CommonResult.success(count);
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    public CommonResult<Object> deleteReadHistories(@RequestParam("ids") String... ids) {
        int count = this.memberReadHistoryService.delete(ids);
        if (count == 0) {
            return CommonResult.failed();
        }
        return CommonResult.success(count);
    }


    @ApiOperation("展示浏览记录")
    @GetMapping("/listHistories")
    public CommonResult<List<MemberReadHistory>> listHistories(@RequestParam("memberId") Long memberId) {
//        CommonResult<List<MemberReadHistory>> hitories ;
        List<MemberReadHistory> histories = this.memberReadHistoryService.list(memberId);
        return CommonResult.success(histories);
    }
}
