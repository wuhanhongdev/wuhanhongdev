package com.dev.mina.tcp.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.WriteRequest;

/**
 * Created by wuhanhong on 2017/6/2.
 */
public class MyFilter extends IoFilterAdapter {
    @Override
    public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
    }

    @Override
    public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        nextFilter.filterWrite(
                session, new DefaultWriteRequest(
                        ((String) writeRequest.getMessage()).toCharArray(), writeRequest.getFuture(), writeRequest.getDestination()));
    }
}
