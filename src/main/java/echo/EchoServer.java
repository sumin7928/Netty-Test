package echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by aic on 2017-07-28.
 */
public class EchoServer {
	public static void main ( String[] args ) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup( 1 );
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try{
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group( bossGroup, workerGroup )
					.channel( NioServerSocketChannel.class )
					.childHandler( new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel( SocketChannel ch ) throws Exception {
							ch.pipeline().addLast( new EchoServerHandler() );
						}
					} );

			ChannelFuture channelFuture = bootstrap.bind( 8888 ).sync();
			channelFuture.channel().closeFuture().sync();
		}
		catch ( Exception e ) {

		}
		finally {
			bossGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}

	}
}
