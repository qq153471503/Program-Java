package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * ��UDP Э�� demo��
 */

/**
 * ��socket�������� רҵ����׽���
 * @author KunGe
 * 
 * DatagramSocket
 * 
 *  �����еĹ��췽�����������Ǵ��е�ַ�ģ��������ڷ��͵�
 * DatagramPachet
 *
 */
public class UDP_ProtocolsDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		sendData();
		receiveData();
	}

	private static void receiveData() throws IOException, UnknownHostException {
		/**
		 * 1������UDP socket
		 * 2�����������õ����ݰ�
		 * 3����������
		 * 4���ر�socket
		 */
		
		System.out.println("receive start...");
		DatagramSocket ds = new DatagramSocket(10000,InetAddress.getByName("192.168.126.1"));
		
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf, buf.length);
		
		//�˷�������
		ds.receive(p);
		String ip = p.getAddress().getHostAddress();
		int port = p.getPort();
		String recvData = new String(p.getData(), 0, p.getLength());
		
		System.out.println(recvData+ip+port);
		
		ds.close();
	}

	private static void sendData() throws Exception {
		
		System.out.println("send starting...");
		//����UDP socket
		DatagramSocket ds = new DatagramSocket();
		
		String str = "UDP ������ʾ��";
		
		byte[] buf = str.getBytes();
		
		//��װUDPЭ�鱨��
		DatagramPacket dp = 
			new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.126.1"),10000);
		
		System.out.println(InetAddress.getByName("������"));
		//��������
		ds.send(dp);
		
		//�ر�socket
		ds.close();
	}

}





