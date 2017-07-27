

class Outer{
	public void method() {
		Object obj = new Object(){
			public void show() {
				System.out.println("outer...show1..run");
			}
		};
		
		//不可以实现下列形式  因为编译Object obj = new Object()这里
		//多态和匿名内部类结合 子类对象 obj向上转型为Object类型，所以引用不到show方法。
//		obj.show();
		
		//而这种方法却可以：
//		new Object(){
//			public void show(){
//				System.out.println("outer...show1..run");
//			}
//		}.show();
	}
}
public class InnerClassAnonymousDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Outer().method();
	}

}
