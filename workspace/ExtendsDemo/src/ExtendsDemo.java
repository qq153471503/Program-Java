/**
 * 本程序要点与细节：子类中的成员变量，先默认初始化，成员变量的显示初始化后于super()父类初始化
 * 
 * 一个对象实例化过程：
 * 1、JVM读取.class文件 加载进内存 并会先加载父类（如果有）
 * 2、在堆中开辟空间 分配地址
 * 3、 并在堆内存中  对对象中的属性进行默认初始化
 * 4、调用构造函数 进行初始化
 * 5、在构造函数中 第一行会先去父类中的构造函数进行初始化
 * 6、 对父类初始化完成后  对子类进行显示初始化
 * 7、 将对象赋给对象引用
 * 8、完成对象实例化
 * */


public class ExtendsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zi zi = new Zi();
		zi.show();
		
		new Manager("LiuAnkun", 10048, 5000, 2000).work();
	}
}


class Fu{
	
	Fu(){
		this.show();
		return ;
	}
	
	public void show(){
		System.out.print("fu...show...\n");
	}
}

class Zi extends Fu{
	int num = 10;
	Zi(){
		super();
		return ;
	}
	
	public void show(){
		System.out.print("Zi....show..."+num+"\n");
	}
}

abstract class Employee{
	private String name;
	private int id;
	private double money;
	
	public abstract void work();
	
	Employee(String name, int id, double money){
		this.id = id;
		this.money = money;
		this.name = name;
	}
}

class Manager extends Employee{
	private double bonus;
	Manager(String name, int id, double money, double bonus){
		super(name, id, money);
		this.bonus = bonus;
	}
	
	public void work(){
		System.out.print("Manger working...\n");
	}
}

class Programer extends Employee{
	Programer(String name, int id, double money ) {
		super(name, id, money);
	}
	public void work() {
		System.out.println("Programmer...working...");
	}
}







