/**
 * 匿名内部类Demo
 * 
 * 
 * 即内部类的简写格式
 * 前提：内部类必须继承或者实现外部类或者接口 
 * 
 * 要点：非静态内部类中 不能定义静态成员
 * 
 * 匿名内部类：其实就是一个匿名子类对象 
 * 
 * 格式： new 父类名或者接口名 {} 
 */
public class InnerClassAnonymousDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Outer().method();
		
		new Outer2().method();
		
		new Outer3().method();
		
		/**
		 * 通常使用场景：
		 * 当函数参数时接口类型时，而且接口中的方法不超过三个，可以使用匿名内部类作为实际参数进行传递
		 * 如下示例：
		 * */
		
		//由此可以看出，建议不要超过三个方法，如果超过了，该类就过于臃肿，show方法的参数就过于庞大，阅读性过差
		show(new Demo2() {
			
			@Override
			public void ziShow() {
				// TODO Auto-generated method stub
				System.out.println("ZISHOW.....");
			}
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("SHOW.......");
			}
		});
	}
	
	public static void show(Demo2 de) {
		de.show();
		de.ziShow();
	}

}


//有名方式 
class Outer{
	int num = 4;
	
	class Inner{
		
		public void show() {
			System.out.println("。。。。Inner....Show"+Outer.this.num);
		}
	}
	
	public void method() {
		new Inner().show();
	}
}

//无名方式

abstract class Demo{
	abstract public void show();
}

class Outer2{
	int num = 5;
	
	class Inner extends Demo{
		
		public void show() {
			System.out.println("。。。。Inner....Show"+Outer2.this.num);
		}
	}
	
	
	
	public void method() {
		//此种方式 只能调用一个方法
		new Demo() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("。。。。Inner....Show"+Outer2.this.num);
			}
			
		}.show();
	}
}


/**
 * 通常使用场景：
 * 当函数参数时接口类型时，而且接口中的方法不超过三个，可以使用匿名内部类作为实际参数进行传递
 * */

interface Demo2{
	abstract public void show();
	abstract public void ziShow();
}
class Outer3{

	class Inner implements Demo2{
		
		public void show() {
			System.out.println("。。。。Inner....Show"+Outer3.this.num);
		}
	}
	
	public void method() {
		//此种方式 可以调用多个方法
		Demo2 de = new Demo2() {
			
			@Override
			public void ziShow() {
				// TODO Auto-generated method stub
				System.out.println("。。。。Inner....Show。。。Outer3..ziShow...");
			}
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("。。。。Inner....Show...outer3...show...");
			}
		};
		
		de.show();
		de.ziShow();
	}
}




