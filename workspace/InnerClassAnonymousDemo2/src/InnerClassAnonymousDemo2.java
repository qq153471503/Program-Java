
public class InnerClassAnonymousDemo2 {

	class Inner{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		show(new Demo() {
			
			@Override
			public void show2() {
				// TODO Auto-generated method stub
				System.out.println("Show2......");
			}
			
			@Override
			public void show1() {
				// TODO Auto-generated method stub
				System.out.println("Show1......");
			}
		});
	}

	public void method() {
		this.new Inner();
	}
	
	public static void  show(Demo de) {
		de.show1();
		de.show2();
	}
}


interface Demo{
	abstract public void show1();
	abstract public void show2();
}



