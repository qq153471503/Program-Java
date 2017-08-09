package practice;

public class SoundCard implements PCI {

	@Override
	public void open() {
		System.out.println("Sound Card open !");
	}

	@Override
	public void close() {
		System.out.println("Sound Card close !");
	}

}
