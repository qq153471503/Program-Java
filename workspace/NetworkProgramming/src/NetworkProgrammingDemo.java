import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class NetworkProgrammingDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {

		InetAddress ip = InetAddress.getLocalHost();

		System.out.println(ip.getHostAddress()+ip.getHostName());
		
		
		Inet4Address i4p = (Inet4Address) Inet4Address.getLocalHost();
		System.out.println(i4p.getHostAddress());
		System.out.println("over");
		
		
		ip = InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostName());
		System.out.println(ip.getHostAddress());
		
	}

}
