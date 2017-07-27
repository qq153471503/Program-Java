

/**
 * ��̬Demo �� ��ߴ������չ�ԣ�ǰ�ڶ���Ĵ������ʹ�ú��ڵ�����
 * ���������й������� ����ʹ�ö�̬
 * instanceof : �����ж϶���ľ������ͣ�ֻ�������������������ж�
 * 
 * ����Ķ�̬�ԣ�static����һ�㲻��Ҫ���ж�̬�ԣ���Ϊ��̬����������󣬿���ʹ������.�����ķ�ʽֱ��ʹ�á�
 * */
public class PolymorphismDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun(new Dog());
		fun(new Cat());
		fun(new Wolf());
		
		//����ת�� Ŀ�ģ�ֻ���ʹ����¼�
		Animal wolf = new Wolf();
		wolf.call();
		
		//����ת�� Ŀ�ģ�Ϊʹ�������е���������
		Wolf w = (Wolf)wolf;
		w.work();
		
		
		//��Ա���������뿴���  ���п����  ������������
		Fu fu = new Zi();
		System.out.println(fu.num);
		
		//��Ա����[�Ǿ�̬��]�� ���뿴��� ���п��ұߣ���������
		Fu2 fu2 = new Zi2();
		fu2.show();
		
		//��Ա����[��̬��]��������������
		fu2.funStatic();  
	}
	
	public static void fun(Animal animal){
		animal.call();
		if(animal instanceof Dog){
			Dog d = (Dog)animal;
			d.eat();
		}else if(animal instanceof Cat){
			Cat c = (Cat)animal;
			c.play();
		}else if(animal instanceof Wolf){
			Wolf w = (Wolf)animal;
			w.work();
		}
	}

}

interface Animal{
	public abstract void call();
}

class Dog implements Animal{
	public void call(){
		System.out.println("����");
	}
	public void eat(){
		System.out.println("�й�ͷ");
	}
}

class Cat implements Animal{
	public void call(){
		System.out.println("����");
	}
	public void play(){
		System.out.println("������");
	}
}

class Wolf implements Animal{
	public void call() {
		System.out.println("��");
	}
	public void work() {
		System.out.println("�ڶ�");
	}
}

//��Ա����ʾ��
class Fu{
	int num = 9;
}

class Zi extends Fu{
	int num = 10;
}

//��Ա����ʾ��  �ص㣡
class Fu2{
	public void show() {
		System.out.println("Fu....show...");
	}
	
	public static void  funStatic() {
		System.out.println("Fu....static...");
	}
}

class Zi2 extends Fu2{
	public void show(){
		System.out.println("zi...show....");
	}

	public static void  funStatic() {
		System.out.println("Zi....static...");
	}
}



