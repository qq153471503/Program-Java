/**
 * final ���η� 
 * */
public class FinalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Final Demo !!");
		
		new Zi().show2();
	}

}

//final ������ �� ʹ���಻�ܹ����̳�
final class Fu{
	public void show(){
		System.out.println("Fu...run...");
	}
}

//final ���η���
class FuTwo{
	final void show(){
		System.out.println("Fu2...show...run...");
	}
	public void show2(){
		System.out.println("Fu2...show2...run...");
	}
}

class Zi extends FuTwo{
	
	public void show2(){
		System.out.println("Zi...show1...run...");
	}
	
	public void show3(){
		System.out.println("Zi...show2...run...");
	}
}

//final ���α��� �� ����֮����һ��������ֻ�ܸ���һ��

