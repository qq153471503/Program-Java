package tomact_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���˽�tomactԭ���Լ�дһ��ģ��ķ�������
 * @author KunGe
 *
 *
 *   �����飺�ó������к��������������127.0.0.1:9090 �س������ɿ���Ч��
 *   
 * ����̨��Ϣ������
 *   
 */

/*

 127.0.0.1:60378...connected!
GET / HTTP/1.1				�������С��� ������Ϣ������ʽ  �������Դ��·��   httpЭ��汾  

 ��������������Ϣͷ��
Accept: text/html, application/xhtml+xml, image/jxr,   �ɽ�����Щ���͵�Ӧ�ó������
Accept-Language: zh-CN
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 Edge/15.15063
Accept-Encoding: gzip, deflate
Host: 127.0.0.1:9090
Connection: Keep-Alive


����������壺���������Զ����һЩ���ݣ������ȷ����У���ʾ����Ϣͷ�ָ�����
 */
public class SimulationTomact {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//��������
		ServerSocket ss = new ServerSocket(9090);
		
		//�õ��ͻ����׽���
		Socket soc = ss.accept();
		
		//
		System.out.println(soc.getLocalAddress().getHostAddress()+":"+soc.getPort()+"...connected!");
		
		//��ȡ����������
		InputStream in = soc.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf, 0,len);
		
		System.out.println(text);
		
		//���ͻ���һ��������Ϣ
		PrintWriter pw = new PrintWriter(soc.getOutputStream(),true);
		pw.println("<font color='red' size='14'>��ӭ���ʣ����Ƿ�����Ϣ��</font>");
		
		soc.close();
		ss.close();
	}

}







