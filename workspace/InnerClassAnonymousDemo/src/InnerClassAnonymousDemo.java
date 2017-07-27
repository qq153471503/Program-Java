/**
 * �����ڲ���Demo
 * 
 * 
 * ���ڲ���ļ�д��ʽ
 * ǰ�᣺�ڲ������̳л���ʵ���ⲿ����߽ӿ� 
 * 
 * Ҫ�㣺�Ǿ�̬�ڲ����� ���ܶ��徲̬��Ա
 * 
 * �����ڲ��ࣺ��ʵ����һ������������� 
 * 
 * ��ʽ�� new ���������߽ӿ��� {} 
 */
public class InnerClassAnonymousDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Outer().method();
		
		new Outer2().method();
		
		new Outer3().method();
		
		/**
		 * ͨ��ʹ�ó�����
		 * ����������ʱ�ӿ�����ʱ�����ҽӿ��еķ�������������������ʹ�������ڲ�����Ϊʵ�ʲ������д���
		 * ����ʾ����
		 * */
		
		//�ɴ˿��Կ��������鲻Ҫ����������������������ˣ�����͹���ӷ�ף�show�����Ĳ����͹����Ӵ��Ķ��Թ���
		show(new Demo2() {
			
			@Override
			public void ziShow() {
				// TODO Auto-generated method stub
				System.out.println("ZISHOW.....");
			}
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("SHOW.......");
			}
		});
	}
	
	public static void show(Demo2 de) {
		de.show();
		de.ziShow();
	}

}


//������ʽ 
class Outer{
	int num = 4;
	
	class Inner{
		
		public void show() {
			System.out.println("��������Inner....Show"+Outer.this.num);
		}
	}
	
	public void method() {
		new Inner().show();
	}
}

//������ʽ

abstract class Demo{
	abstract public void show();
}

class Outer2{
	int num = 5;
	
	class Inner extends Demo{
		
		public void show() {
			System.out.println("��������Inner....Show"+Outer2.this.num);
		}
	}
	
	
	
	public void method() {
		//���ַ�ʽ ֻ�ܵ���һ������
		new Demo() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("��������Inner....Show"+Outer2.this.num);
			}
			
		}.show();
	}
}


/**
 * ͨ��ʹ�ó�����
 * ����������ʱ�ӿ�����ʱ�����ҽӿ��еķ�������������������ʹ�������ڲ�����Ϊʵ�ʲ������д���
 * */

interface Demo2{
	abstract public void show();
	abstract public void ziShow();
}
class Outer3{

	class Inner implements Demo2{
		
		public void show() {
			System.out.println("��������Inner....Show"+Outer3.this.num);
		}
	}
	
	public void method() {
		//���ַ�ʽ ���Ե��ö������
		Demo2 de = new Demo2() {
			
			@Override
			public void ziShow() {
				// TODO Auto-generated method stub
				System.out.println("��������Inner....Show������Outer3..ziShow...");
			}
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("��������Inner....Show...outer3...show...");
			}
		};
		
		de.show();
		de.ziShow();
	}
}



