package cn.dbdj1201.sc.nosql.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


/**
 * 用户商品浏览记录
 *
 * @Author: dbdj1201
 * @Date: 2020-08-11 15:33
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberReadHistory {

    @Id
    private String id;

    @Indexed
    private Long memberId;

    private String memberNickname;

    private String memberIcon;

    @Indexed
    private Long productId;
    private String productName;
    private String productPic;
    private String productSubtitle;
    private String productPrice;
    private LocalDateTime creatTime;

}
