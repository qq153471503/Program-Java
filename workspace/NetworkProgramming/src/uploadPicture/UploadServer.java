package uploadPicture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(10006);
		
		Socket soc = ss.accept();
		
		String ip = soc.getInetAddress().getHostAddress();
		int port = soc.getPort();
		System.out.println(ip+"..connected!");
		
		InputStream rec = soc.getInputStream();
		

		FileOutputStream fos = new FileOutputStream(ip+".bmp");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=rec.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		
		//通知客户端 上传成功
		OutputStream out = soc.getOutputStream();
		out.write("上传成功".getBytes());
		
		fos.close();
		soc.close();
		ss.close();
		
	}

}



