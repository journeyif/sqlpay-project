package com.sqlpay.project.rabbitmq.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConfirmServer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 配置 confirm 机制
     */
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        /**
         *
         * @param correlationData 消息相关的数据，一般用于获取 唯一标识 id
         * @param b 是否发送成功
         * @param error 失败原因
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String error) {
            if (b) {
                System.out.println("confirm 消息发送确认成功...消息ID为：" + correlationData.getId());
            } else {
                System.out.println("confirm 消息发送确认失败...消息ID为：" + correlationData.getId() + " 失败原因: " + error);
            }
        }
    };

    /**
     * 发送消息 参数有：交换机 ，空路由键，消息，并设置一个唯一消息ID
     */
    public void sendConfirm() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", 1);
        map.put("value", "confirm功能的车车");
        rabbitTemplate.convertAndSend("confirm_fanout_exchange",
                "",
                map,
                new CorrelationData("" + System.currentTimeMillis()));
        //使用咱们上方配置的发送回调方法
        rabbitTemplate.setConfirmCallback(confirmCallback);
    }
}
