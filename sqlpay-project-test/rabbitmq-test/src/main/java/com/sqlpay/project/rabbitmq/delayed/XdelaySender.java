package com.sqlpay.project.rabbitmq.delayed;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class XdelaySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, int delayTime) {
        System.out.println("msg= " + msg + ".delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rabbitTemplate.convertAndSend(XdelayConfig.DELAYED_EXCHANGE_XDELAY, XdelayConfig.DELAY_ROUTING_KEY_XDELAY, msg, message -> {
            message.getMessageProperties().setDelay(delayTime);
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}