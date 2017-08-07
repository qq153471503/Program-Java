package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient implements Runnable {

	private Socket soc=null;
	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	StringBuffer sb = null;
	String data=null;
	OutputStream send = null;
	
	public TcpClient(Socket soc) {
		super();
		this.soc = soc;
	}


	@Override
	public void run() {
		
		while(true){
			
			try {
				
				while((data=bufr.readLine()) != null){
					
					send = soc.getOutputStream();
					send.write(data.getBytes());
					
					if(data.equals("over"))
					{
						soc.close();
						break;
					}
					
				}//end of while
			} catch (IOException e) {
				
				throw new RuntimeException("send err ! app is exit.");
			}
		}//end of while
	}

}
