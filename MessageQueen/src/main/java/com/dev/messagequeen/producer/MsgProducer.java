package com.dev.messagequeen.producer;

import com.dev.messagequeen.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service("msgProducer")
public class MsgProducer {
    @Autowired
    private JmsTemplate jmsTmp;

    public void sendMsg(final UserModel userModel){
        jmsTmp.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                message.setObject(userModel);
                return message;
            }
        });
    }
}
