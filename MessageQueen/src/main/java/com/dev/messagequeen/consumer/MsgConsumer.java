package com.dev.messagequeen.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("msgConsumer")
public class MsgConsumer {
    @Autowired
    private JmsTemplate jmsTmp;

    public void consumerMsg(){
        //jmsTmp.
    }
}
