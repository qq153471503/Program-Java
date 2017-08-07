package UDPchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	
	private DatagramSocket ds;
	private BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	String line = null;
	private DatagramPacket dp=null;
	private int port = 10000;
	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			
			System.out.println("�����롾���س����͡���");
				while((line=bufr.readLine()) != null)
				{
					byte[] buf = line.getBytes();
					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"),port);
					ds.send(dp);
					if("over".equals(line))
						break;
				}
			
			ds.close();
		} catch (Exception e) {

		}
	}

}