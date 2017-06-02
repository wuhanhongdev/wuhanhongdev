package com.dev.mina.tcp.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MinaServerAdapter extends IoHandlerAdapter {
    //sessionCreated：创建时回调
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("sessionCreated");
    }
    //sessionOpened:打开时回调
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("sessionOpened");
    }
    //sessionClosed：关闭时回调
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("sessionClosed");
    }
    //sessionIdle:进入空闲时回调
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("sessionIdle");
    }
    //出现异常时回调
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("exceptionCaught："+cause.getMessage());
    }
    /**
     * 接收到消息时回调
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println("Received Message is: " + str);
        if("exit".equals(str)){
            System.out.println("client exit: " + str);
            session.write("client exit");
            session.closeNow();
            return;
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        session.write(format.format(date)+" Received Client Message : "+message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("messageSent");
    }
}
