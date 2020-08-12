package cn.dbdj1201.sc.nosql.elasticsearch.document;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-12 17:50
 */
@Document(indexName = "pms", replicas = 0)
@Data
@NoArgsConstructor
public class EsProduct implements Serializable {

    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    //货号 形如：No6537
    @Field(type = FieldType.Keyword)
    private String productSn;
    private Long brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    private Long productCategoryId;
    @Field(type = FieldType.Keyword)
    private String productCategoryName;
    private String pic;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String subTitle;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String keywords;
    private BigDecimal price;
    private Integer sale;
    //'新品状态:0->不是新品；1->新品'
    private Integer newStatus;
    //'推荐状态；0->不推荐；1->推荐'
    private Integer recommandStatus;
    //库存
    private Integer stock;
    //'促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
    private Integer promotionType;
    private Integer sort;
    @Field(type = FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}
