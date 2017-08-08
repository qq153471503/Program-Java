package tomact_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 【了解tomact原理，自己写一个模拟的服务器】
 * @author KunGe
 *
 *
 *   本试验：该程序运行后，在浏览器中输入127.0.0.1:9090 回车，即可看到效果
 *   
 * 控制台信息解析：
 *   
 */

/*

 127.0.0.1:60378...connected!
GET / HTTP/1.1				【请求行】： 三段信息：请求方式  请求的资源和路径   http协议版本  

 【以下是请求消息头】
Accept: text/html, application/xhtml+xml, image/jxr,   可接受哪些类型的应用程序解析
Accept-Language: zh-CN
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 Edge/15.15063
Accept-Encoding: gzip, deflate
Host: 127.0.0.1:9090
Connection: Keep-Alive


【最后请求体：请求体是自定义的一些内容，必须先发空行，表示和消息头分隔开】
 */
public class SimulationTomact {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//创建服务
		ServerSocket ss = new ServerSocket(9090);
		
		//拿到客户端套接字
		Socket soc = ss.accept();
		
		//
		System.out.println(soc.getLocalAddress().getHostAddress()+":"+soc.getPort()+"...connected!");
		
		//获取发来的数据
		InputStream in = soc.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf, 0,len);
		
		System.out.println(text);
		
		//给客户端一个返回信息
		PrintWriter pw = new PrintWriter(soc.getOutputStream(),true);
		pw.println("<font color='red' size='14'>欢迎访问！我是返回信息！</font>");
		
		soc.close();
		ss.close();
	}

}







