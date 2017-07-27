/**
 * 内部类：
 * 一般用于类的设计
 * 
 * 如果内部类为非静态，该内部类中成员不能为静态的。
 * 
 * 内部类可以放在局部位置上 
 * */
public class InnerClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer out = new Outer();
		out.accessInnerClass();
		
		Outer.Inner oi = new Outer().new Inner();
		oi.show();
		
		Outer2.Inner in = new Outer2.Inner();
		in.show();
		
		Outer3.Inner.show();
		
		
		Outer4 ofour = new Outer4();
		ofour.accessInnerClass();
		
		new Outer5().method();
		
		new Outer6().method();
	}

}


class Outer{
	private int id = 10;
	
	class Inner{		
		public void show(){
			System.out.println("..1..Inner show()。。。"+id);
		}
	}
	
	public void  accessInnerClass() {
		Inner inner = new Inner();
		inner.show();
	}
}

class Outer2{
	private static int id = 10;
	static class Inner{	
		public void show(){
			System.out.println("..2...Inner show()。。。"+id);
		}
	}
	
	public void  accessInnerClass() {
		Inner inner = new Inner();
		inner.show();
	}
}

class Outer3{
	private static int id = 10;
	static class Inner{	
		public static void show(){
			System.out.println("..3..Inner show()。。。"+id);
		}
	}
	
	public void  accessInnerClass() {
		Inner inner = new Inner();
		inner.show();
	}
}

class Outer4{
	int id = 10;
	private class Inner{	
		int id = 15;
		public void show(){
			int id = 20;
			System.out.println(id);
			System.out.println(Inner.this.id);
			System.out.println(Outer4.this.id);
		}
	}
	
	public void  accessInnerClass() {
		new Inner().show();
	}
}


class Outer5{
	int num = 3;
	public void method(){
		class Inner{
			public void show(){
				System.out.println("...5...show..."+Outer5.this.num);
			}
		}
		
		Inner in = new Inner();
		in.show();
	}
}

class Outer6{
	int num = 3;
	public void method(){
		//注意此处  内部类访问局部变量 变量必须为最终类型
		final int x = 6;
		class Inner{
			public void show(){
				System.out.println("...5...show..."+x);
			}
		}
		
		Inner in = new Inner();
		in.show();
	}
}





