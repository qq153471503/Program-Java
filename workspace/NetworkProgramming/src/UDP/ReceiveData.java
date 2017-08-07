package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ��ע�⡿��DatagramPacket����receive����������ʽ
 * @author KunGe
 *
 */
public class ReceiveData {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 1���������󶨵����Ͷ� �˿�
		 * 2�������������ݻ�����
		 * 3����������
		 * 4�����ý��յ��İ����������� ����ip �˿ڵ�
		 * 5����ϵ�׽���
		 */
		
		System.out.println("start receive...");
		DatagramSocket ds = new DatagramSocket(10000);
		
		while(true){
			
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			
			ds.receive(dp);
			
			String data = new String(dp.getData(), 0, dp.getLength());
			int port = dp.getPort();
			String ip = dp.getAddress().getHostAddress();
			
			System.out.println(ip+":"+port+" -> "+data);
			
	//		ds.close();
		}
	}

}