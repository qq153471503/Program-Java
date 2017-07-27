/**
 * 1、抽象类不能背实例化
 * 2、抽象方法只能在抽象类中
 * 3、抽象类必须有其子类覆盖所有的抽象方法，该子类才可以实例化，否则该子类还是抽象类
 * 4、abstract不可以和private共存，因为抽象方法需要被覆盖
 *    		 不可以和static共存，原因：static修饰的方法无需对象，在抽象类中无意义。
 *    		不可以和final共存 原因：final修饰后就锁死了方法，与abstract成对立关系
 * */
public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b = new B();
		b.show();
		b.sleep();
	}

}

//抽象类
abstract class A{
	//抽象函数
	abstract public void show();
	
	public void sleep(){
		System.out.println("Sleeping.....");
	}
}

class B extends A{
	
	public void show(){
		System.out.println("BBBBBB");
	}
}

