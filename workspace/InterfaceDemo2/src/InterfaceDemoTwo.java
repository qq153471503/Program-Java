
/**
 * 
	 接口Interface
	1. 接口中的成员变量默认都是public、static、final类型的，必须被显式初始化
	2. 接口中的方法默认都是public、abstract类型的。
	3. 接口中只能包含public、static、final类型的成员变量和public、abstract类型的成员方法。
	4. 接口没有构造方法，不能被实例化，在接口中定义构造方法是非法的。
	5. 一个接口不能实现另一个接口，但它可以继承多个其他接口。
	
*/
public class InterfaceDemoTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone phone = new Phone();
		useUSB(phone);
		
		useUSB(new Phone());
		phone.call();
		
		new Phone().close();
		
	}
	
	public static void useUSB(USB usb){
		if(usb != null)
			usb.open();
	}

}

interface USB{
	abstract  public void open();
	abstract  public void close();
}

class Phone implements USB{
	public void open(){
		System.out.println("USB open...");
	}
	
	public void close(){
		System.out.println("USB close...");
	}
	public void call() {
		System.out.println("Phone call...");
	}
}



