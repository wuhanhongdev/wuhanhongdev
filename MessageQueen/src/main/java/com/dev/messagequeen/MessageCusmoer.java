package com.dev.messagequeen;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Map;

/**
 * Created by wuhanhong on 2017/6/5.
 */
public class MessageCusmoer {
    private static String condition = "age>=20";
    public static void main(String[] srgs) throws Exception{
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("message");

        javax.jms.MessageConsumer consumer = session.createConsumer(destination,condition);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if(message instanceof MapMessage){
                    try {
                        MapMessage mapMessage = (MapMessage)message;
                        mapMessage.acknowledge();
                        System.out.println(mapMessage.getString("name"));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
