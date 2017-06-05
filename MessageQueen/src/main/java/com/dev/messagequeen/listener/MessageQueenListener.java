package com.dev.messagequeen.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

public class MessageQueenListener implements SessionAwareMessageListener<Message> {
    public void onMessage(Message message, Session session) throws JMSException {
        if(message instanceof MapMessage){
            MapMessage mapMessage = (MapMessage)message;
            System.out.println(mapMessage.getString("message"));
        }
    }
}
