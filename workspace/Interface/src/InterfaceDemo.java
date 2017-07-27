/**
 * 接口中的常见成员：
 * 对于接口中的常见成员，都有固定的修饰符，就算自己不写，也会自己默认加上  如下形式：
 * 1、全局常量：public static final
 * 2、抽象方法：public abstract 
 * 
 * 使用接口 不用继承 用实现，因为接口中全部都要覆盖
 * 类->类：继承		类->接口：实现
 * 接口中的成员，都是公共的，即权限最大
 * 接口不可以被实例化 只能由实现了接口的子类覆盖所有的抽象方法后，该子类才可以实现化
 * */

/**
 * Java不支持多继承 因为会出现调用的不确定性
 * 将多继承机制改良 变成多实现
 * 一个类可以实现多个接口
 * 
 * 一个类在继承另一个类的同时 还可以实现多个接口
 * 
 * 接口与接口之间是继承关系，并且可以多继承
 * */
class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ImplementDemo iface = new ImplementDemo();
		iface.show1();
		
		System.out.println(iface.NUM);
		System.out.println(ImplementDemo.NUM);
		System.out.println(Demo.NUM);

	}

}

interface Demo{
	public static final int NUM = 10;
	public abstract void show1();
	public abstract void show2();
}

interface Demo2{
	public static final int NUM2 = 20;
	public abstract void show3();
}
class ImplementDemo implements Demo,Demo2{
	public void show1(){;
		System.out.println(this.NUM);
	}
	public void show2(){
		
	}
	public void show3(){
		
	}
}

class Fu{
	public void shouFu() {
		
	}
}


//接口的出现 避免了但继承局限性
class Zi extends Fu implements Demo,Demo2{
	public void show1(){;
		System.out.println(this.NUM);
	}
	public void show2(){
		
	}
	public void show3(){
		
	}	
}


interface AA{
	public abstract void aaShow();
}
interface BB{
	public abstract void bbShow();
}

interface CC extends AA,BB{
	public abstract void aaShow(){
		
	}
	public abstract void bbShow(){
			
	}
	public abstract void ccShow(){
		
	}
}

abstract class Test{
	abstract public void test();
}

//class Test2 extends Test{
//	public void test() {
//		
//	}
//}











