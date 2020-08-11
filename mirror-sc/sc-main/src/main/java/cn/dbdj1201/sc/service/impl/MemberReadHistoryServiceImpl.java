package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.nosql.mongodb.document.MemberReadHistory;
import cn.dbdj1201.sc.nosql.mongodb.repository.MemberReadHistoryRepository;
import cn.dbdj1201.sc.service.IMemberReadHistoryService;
import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-11 15:44
 */
@Service
@Slf4j
public class MemberReadHistoryServiceImpl implements IMemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId) {
        return this.memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return this.memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        try {
            memberReadHistory.setId(null);
            memberReadHistory.setCreatTime(LocalDateTime.now());
            MemberReadHistory history = this.memberReadHistoryRepository.save(memberReadHistory);
            log.warn("存入mondodb：{}", history);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(String... ids) {
        log.info("批量删除");
        try {
            List<MemberReadHistory> histories = Arrays.stream(ids).map(id -> {
                MemberReadHistory history = new MemberReadHistory();
                history.setId(id);
                return history;
            }).collect(Collectors.toList());
            this.memberReadHistoryRepository.deleteAll(histories);
        } catch (Exception e) {
            log.warn("删除文档失败");
            return 0;
        }

        List<String> idList = Arrays.asList(ids);
        log.info("删除成功，已被删除的id如下{}", idList);
        return 1;
    }
}
