package tomact_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 服务器用tomact
 * 
 * 该程序模拟IE浏览器
 * 
 * 

【服务器返回的消息】
 HTTP/1.1 200 OK				//应答行：协议版本、应答状态码、应答状态描述信息
 
 200：代表成功  404：找不到
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
		
		//模拟浏览器向tomact服务端发送符合http协议的请求消息
		
		PrintWriter send = new PrintWriter(soc.getOutputStream(),true);
		send.println("GET /myweb/hello.html HTTP/1.1");//该处的路径是tomact的路径
		send.println("Accept: */*");
		send.println("Accept-Language: zh-CN");
		send.println("Host: 127.0.0.1:8080");
		send.println("Connection: close");
		send.println();					//发送空行表示：告诉服务器以下内容是用的自定义的内容消息
		send.println();					//发送空行表示：告诉服务器以下内容是用的自定义的内容消息
		
		
		//接收服务器返回消息
		InputStream reve = soc.getInputStream();
		byte[] buf = new byte[1024];
		int len = reve.read(buf);
		String data = new String(buf,0,len);
		System.out.println(data);
		soc.close();
	}

}



