package demo;

public class Persion {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Persion(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("param Person run ..."+name+":"+age);
	}
	
	public Persion() {
		super();
		System.out.println("Person run ...");
	}
	
	public void show() {
		System.out.println(name+":"+age);
	}

	public void method() {
		System.out.println("method run !");
	}
	
	public void paramMethod(String str, int num) {
		System.out.println("paramMethod run "+str+":"+num);
	}
	
	public static void staticMethod() {
		System.out.println("static method run !");
	}
	private void privateMethod() {
		System.out.println("privateMethod run ...");
	}
}


