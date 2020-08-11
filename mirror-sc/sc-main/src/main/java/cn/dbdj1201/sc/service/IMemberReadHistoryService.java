package cn.dbdj1201.sc.service;

import cn.dbdj1201.sc.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-11 15:43
 */
public interface IMemberReadHistoryService {

    /**
     * 来搞的
     *
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

    /**
     * 根据会员id查询其浏览商品的历史记录
     *
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);

    /**
     * 新增浏览记录
     *
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     *
     * @param ids
     * @return
     */
    int delete(String... ids);

}
