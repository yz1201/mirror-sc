package cn.dbdj1201.sc.service;

import cn.dbdj1201.sc.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品搜索管理Service
 *
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:17
 */
public interface IEsProductService {

    /**
     * 根据mysql中数据信息新建ES索引库
     *
     * @return
     */
    int generateEsDb();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

}
