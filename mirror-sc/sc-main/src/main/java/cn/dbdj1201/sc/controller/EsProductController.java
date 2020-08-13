package cn.dbdj1201.sc.controller;

import cn.dbdj1201.sc.common.api.CommonPage;
import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.nosql.elasticsearch.document.EsProduct;
import cn.dbdj1201.sc.service.IEsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-12 19:37
 */
@RestController
@Api("EsProductController")
@Slf4j
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private IEsProductService esProductService;

    @PostMapping("/create/{id}")
    @ApiOperation("新建某个商品的索引库")
    public CommonResult<EsProduct> createProductIndex(@PathVariable("id") Long id) {
        EsProduct esProduct = this.esProductService.create(id);
        if (esProduct == null) {
            return CommonResult.failed("新建失败w(ﾟДﾟ)w");
        }
        return CommonResult.success(esProduct);
    }

    @PostMapping("/generateIndexs")
    @ApiOperation("新建所有商品索引库")
    public CommonResult<Integer> generateAll() {
        int generateEsDb = this.esProductService.generateEsDb();
        return CommonResult.success(generateEsDb);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("根据id删除商品索引库")
    public CommonResult<String> deleteById(@PathVariable("id") Long id) {
        this.esProductService.delete(id);
        return CommonResult.success("删除成功");
    }

    @GetMapping("/search/simple")
    @ApiOperation("简单搜索")
    public CommonResult<CommonPage<EsProduct>> search(
            @RequestParam String keyword,
            @RequestParam Integer currentPage,
            @RequestParam Integer pageSize
    ) {
        Page<EsProduct> search = this.esProductService.search(keyword, currentPage, pageSize);
        return CommonResult.success(CommonPage.restPage(search));
    }

}
