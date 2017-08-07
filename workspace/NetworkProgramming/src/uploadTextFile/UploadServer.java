package uploadTextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(10005);
		
		Socket soc = ss.accept();
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		
		BufferedWriter bufw = new BufferedWriter(new FileWriter("server.txt"));
		
		String line=null;
		
		while((line=bufIn.readLine()) != null){
			if(line.equals("over"))
				break;
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		
		PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
		out.println("�ϴ��ɹ�!");
		
		bufw.close();
		ss.close();
		soc.close();
	}

}
