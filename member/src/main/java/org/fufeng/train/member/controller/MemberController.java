package org.fufeng.train.member.controller;

import jakarta.annotation.Resource;
import org.fufeng.train.common.resp.CommonResp;
import org.fufeng.train.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

/**
 * 会员管理
 *
 * @author fufeng
 * @Date 2024-03-16 12:40
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(count);
        return commonResp;
    }

}
