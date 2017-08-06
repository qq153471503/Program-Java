package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendData {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 1、创建套接字
		 * 2、创建数据
		 * 3、封装数据包
		 * 4、发送
		 * 5、关闭套接字
		 */
		System.out.println("send start...");
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line=bufr.readLine()) != null){
			if("over".equals(line))
				break;
			
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"),10000);
			ds.send(dp);
		}
		
		
		
		
		ds.close();
		
		System.out.println("send end ...");
	}

}
