class inheritanceDemo{
	public static void main(String[] args){
		System.out.println("inheritance Demo !");
		
		Student stu = new Student();
		stu.show();
		
		Worker wok = new Worker();
		wok.work(33);
		
		Home home = new Home();
		home.setAge(44);
		home.setNum(4);
		home.showNum();
		
		Bclass bc = new	Bclass();
		bc.show();
		
		NewPhone np = new NewPhone();
		np.show();
		np.call();
		
		
		new Zi();
		
	}
}


class Student{
	private int age;
	private String name;
	
	Student() {
		this.age = 0;
		this.name = null;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age) {
		if(age < 0)
			return ;
		this.age = age;
	}
	
	public void show() {
		System.out.println(this.name+":"+this.age);
	}
}

class Worker extends Student{
	public void work(int age) {
		this.setAge(age);
		System.out.println(this.getAge());
	}
}

class Home extends Worker{
	private int num;
	 Home() {
		 this.num = 0;
	}
	 
	 public void setNum(int num){
		 if(num <= 0)
			 return ;
		 this.num = num;
	 }
	 
	 public int getNum(){
		 return this.num;
	 }
	 
	 public void showNum() {
		 System.out.println(this.num);
	 }
}

class Aclass{
	private int num = 4;
	public int getNum(){
		return num;
	}
	
	private void showNum(){
		System.out.println(this.num);
	}
}

class Bclass extends Aclass{
	int num = 8;
	void show(){
		System.out.println(this.num+"...."+super.getNum());
	}
}

class Phone{
	public void call() {
		
		System.out.println("call");
	}
	
	public void show() {
		System.out.println("number");
	}
}

class NewPhone extends Phone{
	public void show() {
		super.show();
		System.out.println("name");
		System.out.println("picture");
	}
}


class Fu{
	Fu(){
		System.out.print("fu ...\n");
	}
	
	Fu(String name){
		System.out.print(name);
	}
}

//在子类中 构造函数有隐式语句
class Zi extends Fu{
	Zi(){
		//此处有 super(); //调用父类的空参数构造函数  本质是调用默认的构造函数
		//如果调用带参数的构造函数，需要在super（） 的括号中填入参数 类型和构造函数类型需要一致  如下：
		super("name");
		System.out.print(" - zi ...\n");
		return ;
	}
}





