package tomact_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * ��������tomact
 * 
 * �ó���ģ��IE�����
 * 
 * 

�����������ص���Ϣ��
 HTTP/1.1 200 OK				//Ӧ���У�Э��汾��Ӧ��״̬�롢Ӧ��״̬������Ϣ
 
 200������ɹ�  404���Ҳ���
Server: Apache-Coyote/1.1
Accept-Ranges: bytes
ETag: W/"169-1502200654623"
Last-Modified: Tue, 08 Aug 2017 13:57:34 GMT
Content-Type: text/html
Content-Length: 169
Date: Tue, 08 Aug 2017 14:01:58 GMT
Connection: close

 * */
public class MyBrowser {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket soc = new Socket("127.0.0.1",8080);
		
		//ģ���������tomact����˷��ͷ���httpЭ���������Ϣ
		
		PrintWriter send = new PrintWriter(soc.getOutputStream(),true);
		send.println("GET /myweb/hello.html HTTP/1.1");//�ô���·����tomact��·��
		send.println("Accept: */*");
		send.println("Accept-Language: zh-CN");
		send.println("Host: 127.0.0.1:8080");
		send.println("Connection: close");
		send.println();					//���Ϳ��б�ʾ�����߷����������������õ��Զ����������Ϣ
		send.println();					//���Ϳ��б�ʾ�����߷����������������õ��Զ����������Ϣ
		
		
		//���շ�����������Ϣ
		InputStream reve = soc.getInputStream();
		byte[] buf = new byte[1024];
		int len = reve.read(buf);
		String data = new String(buf,0,len);
		System.out.println(data);
		soc.close();
	}

}



