
class CodeBlocksDemo{
	
	public static void main(String[] args){
		System.out.println("code blocks demo !");
		
		Person per = new Person();
		Person per2 = new Person("Liuankun");
		
		System.out.println("---------------------------");
		
		Person2 per3 = new Person2();
		Person2 per4 = new Person2("Kunge");
		
	}
}


//构造代码块
class Person{
	
	private String name;
	
	{
		System.out.println("Persion....running !");
	}
	
	Person(){
		this.name = "baby";
		this.cry();
	}
	Person(String name){
		this.name = name;
		this.cry();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void cry(){

		System.out.println("Persion.."+this.name+"..crying !");
	}
	
	public void show() {
		
		System.out.println("Persion....crying !");
	}
	
}
//静态代码块
class Person2{
	
	private String name;
	
	static
	{
		System.out.println("Persion....running !");
	}
	
	Person2(){
		this.name = "baby";
		this.cry();
	}
	Person2(String name){
		this.name = name;
		this.cry();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void cry(){

		System.out.println("Persion.."+this.name+"..crying !");
	}
	
}