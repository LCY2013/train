package org.fufeng.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.fufeng.train.common.resp.CommonResp;
import org.fufeng.train.common.resp.MemberLoginResp;
import org.fufeng.train.member.req.MemberLoginReq;
import org.fufeng.train.member.req.MemberRegisterReq;
import org.fufeng.train.member.req.MemberSendCodeReq;
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

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
        // CommonResp<Long> commonResp = new CommonResp<>();
        // commonResp.setContent(register);
        // return commonResp;
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }

}
