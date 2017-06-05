package com.dev.messagequeen;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageProducer {
    public static void main(String[] srgs) throws Exception{
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = session.createQueue("message");

        javax.jms.MessageProducer producer = session.createProducer(null);

        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setString("name","张sasadaasdas");
        mapMessage.setIntProperty("age",15);
        producer.send(destination,mapMessage,DeliveryMode.NON_PERSISTENT,4,1000*60*60);

        mapMessage = session.createMapMessage();
        mapMessage.setString("name","张231231");
        mapMessage.setIntProperty("age",20);
        producer.send(destination,mapMessage,DeliveryMode.NON_PERSISTENT,4,1000*60*60);

        mapMessage = session.createMapMessage();
        mapMessage.setString("name","张zxcxzc");
        mapMessage.setIntProperty("age",25);
        producer.send(destination,mapMessage,DeliveryMode.NON_PERSISTENT,4,1000*60*60);

        mapMessage = session.createMapMessage();
        mapMessage.setString("name","张l;l;l");
        mapMessage.setIntProperty("age",30);
        producer.send(destination,mapMessage,DeliveryMode.NON_PERSISTENT,4,1000*60*60);

        if(connection != null){
            connection.close();
        }
    }
}
