package com.dev.mina.tcp.server;

import com.dev.mina.tcp.Constants;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MinaServer {

    public void createIoAcceptor() throws Exception{
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.setHandler(new MinaServerAdapter());
        acceptor.bind(new InetSocketAddress(Constants.PORT));
        System.out.println("Server started...");
    }

    public static void main(String[] args){
        try {
            //创建一个IoAcceptor实例
            NioSocketAcceptor acceptor = new NioSocketAcceptor();
            //添加解码器
            acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory()));
            //添加日志
            acceptor.getFilterChain().addLast("logger", new LoggingFilter());
            //设置进入空闲时间
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
            //指定IoHandler
            acceptor.setHandler(new MinaServerAdapter());
            //绑定端口
            acceptor.bind(new InetSocketAddress(Constants.PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
