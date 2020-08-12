package cn.dbdj1201.sc.nosql.elasticsearch.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 搜索中的商品属性信息
 *
 * @Author: dbdj1201
 * @Date: 2020-08-12 18:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    //编号
    private Long id;
    //属性id
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    //属性类型 0-》规格，1-》参数
    private Integer type;
    //属性名
    @Field(type = FieldType.Keyword)
    private String name;
}
