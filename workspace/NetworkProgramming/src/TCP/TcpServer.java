package TCP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer implements Runnable {

	private ServerSocket ss = null;
	private File file = null;
	private BufferedWriter bufw = null;
	private Socket soc = null;
	private InputStream in = null;
	private byte[] buf = new  byte[1024];
	private int len=0;
	String data = null;
	
	public TcpServer(ServerSocket ss, File file) {
		super();
		this.ss = ss;
		this.file = file;
		try {
			this.bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			
			throw new RuntimeException("�޷�д���ļ���");
		}
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				soc = ss.accept();
				in = soc.getInputStream();
				len = in.read(buf);
				data = new String(buf, 0, len);
				
				if(data.equals("over")){
//					soc.close();
//					bufw.close();
					break;
				}
				System.out.println(soc.getInetAddress().getHostAddress()+":"+soc.getPort()+" -> "+data);
				bufw.write(data);
				bufw.flush();
				
			} catch (IOException e) {
				
				throw new RuntimeException("�ͻ��˷��ʱ���!");
			}finally {
				try {
					bufw.close();
				} catch (IOException e) {
					
					throw new RuntimeException("�ļ��ر�ʧ�ܣ�");
				}
			}
		}
	}

}


