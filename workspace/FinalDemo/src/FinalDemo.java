/**
 * final 修饰符 
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

//final 修饰类 ： 使该类不能够被继承
final class Fu{
	public void show(){
		System.out.println("Fu...run...");
	}
}

//final 修饰方法
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

//final 修饰变量 ： 修饰之后是一个常量，只能复制一次

