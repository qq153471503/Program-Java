package TCP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 【练习题】：客户端由控制台读取字母数据，服务端收到后显示在控制台，并将数据转换为大写，存储在硬盘上
 * 知道客户端输入over结束。
 * @author KunGe
 *
 */
public class PriacticeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

		File file = new File("G:\\DATA.TXT");
		TcpServer server = new TcpServer(new ServerSocket(10005), file);
		Thread ser = new Thread(server);
		ser.start();
		

		Socket soc = new Socket("127.0.0.1", 10005);
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(soc.getOutputStream())
		OutputStream out = soc.getOutputStream();
		
		String line = null;

			System.out.print("请输入字母： ");
			while((line=bufr.readLine()) != null){
				
				out.write(line.getBytes());
				out.flush();
				if(line.equals("over")){
//					bufr.close();
//					soc.close();
					break;
				}
			}

		}
}

