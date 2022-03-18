package com.sqlpay.project.rabbitmq;

import com.sqlpay.project.rabbitmq.confirm.ConfirmServer;
import com.sqlpay.project.rabbitmq.delayed.XdelaySender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangy
 * @date 2021 - 08 - 15 - 16:20
 */
@Slf4j
@RestController
@RequestMapping("/test/rabbitmq")
public class RabbitmqController {

    @Autowired
    private ConfirmServer confirmServer;

    @Autowired
    private XdelaySender xdelaySender;

    @GetMapping("/sendConfirm")
    public Object sendConfirm() {
        confirmServer.sendConfirm();
        return "success";
    }

    @GetMapping("/send")
    public Object send(Integer time) {
        if (time == null) {
            time = 10000;
        }
        xdelaySender.send("发送一个测试消息," + time / 1000 + "秒", time);
        return "success";
    }
}
