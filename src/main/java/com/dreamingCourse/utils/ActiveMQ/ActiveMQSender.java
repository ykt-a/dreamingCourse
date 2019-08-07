package com.dreamingCourse.utils.ActiveMQ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author zth
 * @Date 2019-08-04 16:57
 * 消息队列生产者
 */
@Component
public class ActiveMQSender {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /*
     * 发送消息，destination是发送到的队列，message是待发送的消息
     */
    public void sendChannelMess(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
