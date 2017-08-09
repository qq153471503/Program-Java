package practice;

public class NetWorkCard implements PCI {

	@Override
	public void open() {
		System.out.println("Network Open !");
	}

	@Override
	public void close() {
		System.out.println("Network Close !");
	}

}
