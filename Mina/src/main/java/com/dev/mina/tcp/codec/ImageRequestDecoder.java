package com.dev.mina.tcp.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class ImageRequestDecoder  extends CumulativeProtocolDecoder {
    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        if (ioBuffer.remaining() >= 12) {
            int width = ioBuffer.getInt();
            int height = ioBuffer.getInt();
            int numberOfCharachters = ioBuffer.getInt();
            ImageRequest request = new ImageRequest(width, height, numberOfCharachters);
            ioSession.write(request);
            return true;
        } else {
            return false;
        }
    }
}
