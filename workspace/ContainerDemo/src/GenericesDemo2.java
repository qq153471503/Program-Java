
public class GenericesDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		show3();
	}

	private static void show3() {
		InterImpl2<Person2> in = new InterImpl2<Person2>();
		
		in.show(new Person2(38, "小白"));
	}

	private static void show2() {
		InterImpl in = new InterImpl();
		in.show("show 1...");
	}

	public void show() {
		Tool<Person2, Animal> tool = new Tool<Person2,Animal>();
		
		tool.setC1(new Person2(10, "李明"));
		tool.setC2(new Animal("dog", 10));
		
		Person2 p = tool.getC1();
		Animal ai = tool.getC2();
		
		System.out.println(p.getAge()+p.getName());
		System.out.println(ai.getName()+ai.getNum());
		
		tool.show("asd");		//将泛型定义在了方法上
		tool.show(9);
		tool.show(new Person2(10,"hah"));
	}
}

