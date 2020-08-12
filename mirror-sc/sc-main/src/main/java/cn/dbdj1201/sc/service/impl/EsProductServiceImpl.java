package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.dao.IEsProductDao;
import cn.dbdj1201.sc.nosql.elasticsearch.document.EsProduct;
import cn.dbdj1201.sc.nosql.elasticsearch.repository.EsProductRepository;
import cn.dbdj1201.sc.service.IEsProductService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:17
 */
@Service
@Slf4j
public class EsProductServiceImpl implements IEsProductService {

    @Autowired
    private EsProductRepository productRepository;

    @Autowired
    private IEsProductDao productDao;

    /**
     * 根据商品库生成搜索索引库
     *
     * @return -1出问题了，result产生doc数目
     */
    @Override
    public int generateEsDb() {
        List<EsProduct> allProducts = this.productDao.findAllProducts(null);
        int result = 0;
        try {
            if (CollectionUtil.isEmpty(allProducts)) {
                log.warn("商品库空了？");
                throw new Exception("完蛋(￣y▽,￣)╭ ");
            }

            Iterable<EsProduct> esProducts = this.productRepository.saveAll(allProducts);
            while (esProducts.iterator().hasNext()) {
                esProducts.iterator().next();
                result++;
            }
//            allProducts.forEach(product -> this.productRepository.save(product));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return result;
    }

    @Override
    public void delete(Long id) {
//        List<EsProduct> products = this.productDao.findAllProducts(id);
//        if (CollectionUtil.isEmpty(products)) {
//            log.warn("无此产品");
//            try {
//                throw new Exception("出问题了");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        EsProduct product = products.get(0);
        log.warn("从索引库中删除当前商品");
        this.productRepository.deleteById(String.valueOf(id));
    }

    @Override
    public EsProduct create(Long id) {
        List<EsProduct> products = this.productDao.findAllProducts(id);
        if (CollUtil.isEmpty(products)) {
            log.warn("查找的特定商品已不可选");
            return null;
        }
        //说实话没懂，只是为了节省时间?不便于理解了。
        EsProduct result = null;
        if (products.size() > 0) {
            result = this.productRepository.save(products.get(0));
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(id -> this.productRepository.deleteById(String.valueOf(id)));
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        return this.productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword,
                PageRequest.of(pageNum, pageSize));
    }
}
