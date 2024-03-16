package org.fufeng.train.member.service;

import jakarta.annotation.Resource;
import org.fufeng.train.member.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  会员服务
 *
 * @author fufeng
 * @Date 2024-03-16 12:42
 */
@Service
public class MemberService {
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

}
