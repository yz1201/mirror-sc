package cn.dbdj1201.sc.controller;


import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.entity.PmsBrand;
import cn.dbdj1201.sc.service.IPmsBrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
@Api(tags = "PmsBrandController")
@RestController
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {

    @Autowired
    IPmsBrandService pmsBrandService;

    @ApiOperation("获取所有品牌列表")
    @GetMapping("listAll")
    public CommonResult<List<PmsBrand>> findAllBrands() {
        log.info("查询所有品牌");
        return CommonResult.success(pmsBrandService.list());
    }

    @ApiOperation(("新增品牌"))
    @PostMapping("/create")
    public CommonResult<PmsBrand> createBrand(@RequestBody PmsBrand pmsBrand) {
        log.info("create brand");
        boolean saveResult = this.pmsBrandService.save(pmsBrand);
        if (!saveResult) {
            log.error("新增失败");
            return CommonResult.failed("新增失败");
        }
        log.info("add successful");
        return CommonResult.success(pmsBrand, "新增成功");
    }

    @ApiOperation(("根据ID删除某品牌"))
    @PostMapping("/delete/{id}")
    public CommonResult<PmsBrand> deleteBrand(@PathVariable Long id) {
        PmsBrand delBrand = this.pmsBrandService.getById(id);
        if (delBrand == null) {
            log.error("删除品牌，根据id查询，发现无此品牌");
            CommonResult.failed("无此品牌");
        }
        log.info("品牌存在，执行删除");
        boolean delFlag = this.pmsBrandService.removeById(id);
        if (!delFlag) {
            log.error("未知因素，删除失败w(ﾟДﾟ)w");
            CommonResult.failed("删除失败");
        }
        return CommonResult.success(delBrand, "这哥们被删了");
    }

    @ApiOperation(("根据id查询品牌"))
    @GetMapping("{id}")
    public CommonResult<PmsBrand> getBrand(@PathVariable Long id) {
        log.info("查询id为{}的品牌", id);
        PmsBrand brand = this.pmsBrandService.getById(id);
        if (brand != null) {
            log.error("这牌子信息呢？");
            CommonResult.failed("无此品牌");
        }
        return CommonResult.success(brand);
    }

    @ApiOperation(("修改品牌信息"))
    @PostMapping("/update/{id}")
    public CommonResult<PmsBrand> modifyBrandInfo(@RequestBody PmsBrand pmsBrandDto, @PathVariable Long id) {
        CommonResult<PmsBrand> commonResult;
        log.info("根据id更新品牌");
        boolean updateFlag = this.pmsBrandService.update(pmsBrandDto, new QueryWrapper<PmsBrand>().eq("id", id));
        if (!updateFlag) {
            commonResult = CommonResult.failed("更新失败");
            log.debug("更新失败了");
        } else {
            commonResult = CommonResult.success(this.pmsBrandService.getById(id));
            log.info("更新成功");
        }
        return commonResult;
    }

    @ApiOperation(("分页查询"))
    @GetMapping("/list")
    public CommonResult<IPage<PmsBrand>> listBrandByPage(
            @RequestParam(defaultValue = "1", value = "currentPage", required = false) Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize
    ) {
        log.info("brand page query");
        Page<PmsBrand> brandPage = new Page<>(currentPage, pageSize);
        IPage<PmsBrand> page = this.pmsBrandService.page(brandPage);
        log.info("分页查询结果：{}", page.getRecords());
        return CommonResult.success(page);
    }

}
