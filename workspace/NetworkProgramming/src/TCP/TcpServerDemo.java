package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServerDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		//创建服务短对象
		ServerSocket ss = new ServerSocket(10002);
		
		//获取连接过来的对象
		Socket soc = ss.accept();
		
		//通过socket对象获取输入流，读取客户端发来的数据
		InputStream in = soc.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		String data = new String(buf, 0, len);
		int port = soc.getPort();
		String ip = soc.getInetAddress().getHostAddress();
		System.out.println(ip+":"+port+" -> "+data);
		
		
		OutputStream retu = soc.getOutputStream();
		retu.write("我是返回信息！".getBytes());
		
		soc.close();
	}

}
