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

		//��������̶���
		ServerSocket ss = new ServerSocket(10002);
		
		//��ȡ���ӹ����Ķ���
		Socket soc = ss.accept();
		
		//ͨ��socket�����ȡ����������ȡ�ͻ��˷���������
		InputStream in = soc.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		String data = new String(buf, 0, len);
		int port = soc.getPort();
		String ip = soc.getInetAddress().getHostAddress();
		System.out.println(ip+":"+port+" -> "+data);
		
		
		OutputStream retu = soc.getOutputStream();
		retu.write("���Ƿ�����Ϣ��".getBytes());
		
		soc.close();
	}

}
