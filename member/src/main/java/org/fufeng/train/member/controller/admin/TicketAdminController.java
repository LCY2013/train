package org.fufeng.train.member.controller.admin;

import org.fufeng.train.common.resp.CommonResp;
import org.fufeng.train.common.resp.PageResp;
import org.fufeng.train.member.req.TicketQueryReq;
import org.fufeng.train.member.resp.TicketQueryResp;
import org.fufeng.train.member.service.TicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket")
public class TicketAdminController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<TicketQueryResp>> queryList(@Valid TicketQueryReq req) {
        PageResp<TicketQueryResp> list = ticketService.queryList(req);
        return new CommonResp<>(list);
    }

}
