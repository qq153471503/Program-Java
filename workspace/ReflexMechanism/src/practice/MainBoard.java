package practice;

public class MainBoard {

	public void run() {
		System.out.println("main board run !");
	}
	
	public void usePCI(PCI pci) {
		if(pci != null){
			pci.open();
			pci.close();
		}
	}
}
