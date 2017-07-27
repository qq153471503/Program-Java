
/**
 * 单例设计模式：一种思想，能够解决问题：可以保证一个类在内存中的对象唯一性 单例：单个实例
 * @author 刘安坤
 * @version v1.0 
 * */



class SingleDemoMode{
	public static void main(String[] args) {
		System.out.println("Single mode demo !");
		
		SingleMode ss = SingleMode.getInstance();
		
		Test t1 = Test.getInstance();
		t1.setNum(10);
		Test t2 = Test.getInstance();
		t2.setNum(20);
		
		System.out.println(t1.getNum());
		System.out.println(t2.getNum());
	}
}

class SingleMode{
	private static SingleMode sm = new SingleMode();
	
	private SingleMode () {
		
	}
	
	public static SingleMode getInstance() {
		return sm;
	}
}

//饿汉式
class Test{
	private Test(){};
	
	private static Test t = new Test();
	private int num;
	
	
	public static Test getInstance(){
		return t;
	}
	public void setNum(int num){
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
}

//懒汉式
class Test2{
	private static Test2 t2 = null;
	private Test2(){};
	
	public static Test2 getInstance(){
		if(t2 == null)
			t2 = new Test2();
		
		return t2;
	}
}



