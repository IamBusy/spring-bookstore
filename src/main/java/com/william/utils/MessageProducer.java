package com.william.utils;

import com.william.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.Map;

/**
 * Created by william on 15/04/2017.
 */
@Component
public class MessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(Destination destination, final Map<String,?> message) {
        jmsTemplate.convertAndSend(destination,message);
    }
}
