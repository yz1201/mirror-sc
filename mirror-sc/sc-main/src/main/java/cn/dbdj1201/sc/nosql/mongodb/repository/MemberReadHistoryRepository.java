package cn.dbdj1201.sc.nosql.mongodb.repository;

import cn.dbdj1201.sc.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史数据集合-仓库
 *
 * @Author: dbdj1201
 * @Date: 2020-08-11 15:39
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
