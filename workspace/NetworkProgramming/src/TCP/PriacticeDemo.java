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
 * ����ϰ�⡿���ͻ����ɿ���̨��ȡ��ĸ���ݣ�������յ�����ʾ�ڿ���̨����������ת��Ϊ��д���洢��Ӳ����
 * ֪���ͻ�������over������
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

			System.out.print("��������ĸ�� ");
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
