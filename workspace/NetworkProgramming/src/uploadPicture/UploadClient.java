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
		
		
		//��ȡҪ�ϴ�������˵�ͼƬ�ļ�
		FileInputStream fis = new FileInputStream("pic.bmp");
		
		
		OutputStream send = soc.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf)) != -1){
			send.write(buf,0,len);
		}
		
		//֪ͨ����� �����Ѿ�������ϣ�ֹͣ��ȡ
		soc.shutdownOutput();
		
		//���շ���˻�Ӧ��֪ͨ����
		InputStream receiveData = soc.getInputStream();
		byte[] bufRec = new byte[1024];
		int lenIn = receiveData.read(bufRec);
		String text = new String(bufRec,0, lenIn);
		System.out.println(text);
		
		soc.close();
		send.close();
		
	}

}
