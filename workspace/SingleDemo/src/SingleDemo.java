
/**
 * �������ģʽ��һ��˼�룬�ܹ�������⣺���Ա�֤һ�������ڴ��еĶ���Ψһ�� ����������ʵ��
 * @author ������
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

//����ʽ
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

//����ʽ
class Test2{
	private static Test2 t2 = null;
	private Test2(){};
	
	public static Test2 getInstance(){
		if(t2 == null)
			t2 = new Test2();
		
		return t2;
	}
}



