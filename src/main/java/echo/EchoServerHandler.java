package echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by aic on 2017-07-28.
 */
public class EchoServerHandler extends SimpleChannelInboundHandler {

	@Override
	protected void channelRead0( ChannelHandlerContext ctx, Object msg ) throws Exception {
		System.out.println( "message : " + msg );
	}

	@Override
	public void channelReadComplete( ChannelHandlerContext ctx ) throws Exception {
		System.out.println( "complete read" );
		super.channelReadComplete( ctx );
	}

	@Override
	public void exceptionCaught( ChannelHandlerContext ctx, Throwable cause ) throws Exception {
		super.exceptionCaught( ctx, cause );
	}
}
