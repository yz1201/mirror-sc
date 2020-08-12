package cn.dbdj1201.sc.dao;

import cn.dbdj1201.sc.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 从mysql操作pms_product
 *
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:27
 * 自定义DAO
 */
public interface IEsProductDao {

    /**
     * @return 根据商品id数据库中所有商品信息
     */
    List<EsProduct> findAllProducts(@Param("id") Long id);

}
