package org.fufeng.train.business.controller;

import org.fufeng.train.business.req.DailyTrainTicketQueryReq;
import org.fufeng.train.business.resp.DailyTrainTicketQueryResp;
import org.fufeng.train.business.service.DailyTrainTicketService;
import org.fufeng.train.common.resp.CommonResp;
import org.fufeng.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }

}
