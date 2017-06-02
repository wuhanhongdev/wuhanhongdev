package com.dev.mina.tcp.client;

import com.dev.mina.tcp.Constants;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * Created by wuhanhong on 2017/6/2.
 */
public class MinaClient {
    private static Logger logger = Logger.getLogger(MinaClient.class);
    public static void main(String[] args){
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory()));
        connector.setConnectTimeoutMillis(Constants.CONNECT_TIMEOUT);
        connector.setHandler(new ClientMessageHandler());
        IoSession session = null;
        try {
            session = connector.connect(new InetSocketAddress(Constants.HOSTNAME, Constants.PORT)).getSession();
            session.setAttribute("attr",100);
            int attr = (Integer) session.getAttribute("attr");
            session.setAttribute("attr",attr+100);
            for(int i=0;i<10;i++){
                session.write("mina");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            logger.info("客户端链接异常...");
        }

        session.getCloseFuture().awaitUninterruptibly();
        logger.info("Mina要关闭了");
        connector.dispose();
    }
}
