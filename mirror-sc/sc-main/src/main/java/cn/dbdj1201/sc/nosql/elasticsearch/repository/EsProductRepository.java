package cn.dbdj1201.sc.nosql.elasticsearch.repository;

import cn.dbdj1201.sc.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:11
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, String> {

    /**
     * @param name      商品名称
     * @param subTitile 商品子标题
     * @param keywords  商品关键字
     * @param pageable  分页参数
     * @return  
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitile, String keywords, Pageable pageable);

}
