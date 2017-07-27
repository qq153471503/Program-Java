
class objectDemo{
	
	int i = 10;
	
	public static void main(String[] args){
		
		Person person = new Person(10, "LiuAnkun");
		
		StaticDemo stad = new StaticDemo();
		stad.sex = 1;
		stad.country = "����";
		stad.show();
		
		stad.country = "changqing";
		stad.show();
		
		
//		objectDemo od = new objectDemo(); //����д����������ķ�ʽ ���£�
//		od.show();
		
		new objectDemo().show();
	}
	
	public void show(){
		System.out.println(i);
	}
}

class StaticDemo{
	String country;
	static int sex = -1;
	public void show(){
		System.out.println("�ص㣺"+this.country+"\t"+"sex��"+this.sex);
	}
}

class Person{
	private int age;
	private String name;
	public void setAge(int x){
		age = x;
	}
	public int getAge(){
		return age;
	}
	
	public void speak(){
		System.out.println("num is :"+this.age+"\t"+"name is :"+this.name);
	}
	
	Person(){
		System.out.println("Person run !");
	}
	
	Person(int age){
		this.age = age;
	}
	Person(int age,String name){
//		this.age = age; //��д��������ʽ
		this(age);
		this.name = name;
//		System.out.println("Person run !"+"\t"+"String is :"+str);
		this.speak();
	}
}






