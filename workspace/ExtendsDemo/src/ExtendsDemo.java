/**
 * ������Ҫ����ϸ�ڣ������еĳ�Ա��������Ĭ�ϳ�ʼ������Ա��������ʾ��ʼ������super()�����ʼ��
 * 
 * һ������ʵ�������̣�
 * 1��JVM��ȡ.class�ļ� ���ؽ��ڴ� �����ȼ��ظ��ࣨ����У�
 * 2���ڶ��п��ٿռ� �����ַ
 * 3�� ���ڶ��ڴ���  �Զ����е����Խ���Ĭ�ϳ�ʼ��
 * 4�����ù��캯�� ���г�ʼ��
 * 5���ڹ��캯���� ��һ�л���ȥ�����еĹ��캯�����г�ʼ��
 * 6�� �Ը����ʼ����ɺ�  �����������ʾ��ʼ��
 * 7�� �����󸳸���������
 * 8����ɶ���ʵ����
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







