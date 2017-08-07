package uploadPicture;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket soc = new Socket("127.0.0.1", 10006);
		
		
		//读取要上传到服务端的图片文件
		FileInputStream fis = new FileInputStream("pic.bmp");
		
		
		OutputStream send = soc.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf)) != -1){
			send.write(buf,0,len);
		}
		
		//通知服务端 数据已经发送完毕，停止读取
		soc.shutdownOutput();
		
		//接收服务端回应的通知数据
		InputStream receiveData = soc.getInputStream();
		byte[] bufRec = new byte[1024];
		int lenIn = receiveData.read(bufRec);
		String text = new String(bufRec,0, lenIn);
		System.out.println(text);
		
		soc.close();
		send.close();
		
	}

}
