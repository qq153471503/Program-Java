package url_demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * 【注意】：使用本程序需要打开tomact
 * @author KunGe
 *
 */
public class URL_Demo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		demo_1();
		
		
	}

	private static void demo_1() throws MalformedURLException, IOException {
		// ?name=list 表示参数信息
		String str_url = "http://127.0.0.1:8080/myweb/hello.html?name=list";
		URL url = new URL(str_url);
		System.out.println(":"+url.getProtocol());
		System.out.println(":"+url.getHost());
		System.out.println(":"+url.getPort());
		System.out.println(":"+url.getPath());
		System.out.println(":"+url.getFile());		//如果没有name=list  该信息与getPath一样
		System.out.println(":"+url.getQuery());		//表示参数信息
		System.out.println();
		
		
		//获取url对象的连接器对象   他可以连接到指定的url上
		URLConnection con = url.openConnection();
		//sun.net.www.protocol.http.HttpURLConnection:http://127.0.0.1:8080/myweb/hello.html?name=list
		System.out.println(con);
		
		System.out.println(con.getHeaderField("Content-Type"));
		
		System.out.println();
		
		InputStream rece = con.getInputStream();
		
		
//		InputStream rece = url.openStream();
//		
		byte[] buf = new byte[1024];
		
		int len = rece.read(buf);
		
		String text = new String(buf,0,len);
		
		System.out.println(text);
	}

}
