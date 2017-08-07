package chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Chat {

	/**
	 * @param args
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {

		DatagramSocket send = new DatagramSocket();
		DatagramSocket recv = new DatagramSocket(10000);
		Send s = new Send(send);
		Receive r = new Receive(recv);
		
		Thread se = new Thread(s);
		Thread re = new Thread(r);
		
		se.start();
		re.start();
		
	}

}
