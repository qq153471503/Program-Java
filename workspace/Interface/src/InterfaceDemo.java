/**
 * �ӿ��еĳ�����Ա��
 * ���ڽӿ��еĳ�����Ա�����й̶������η��������Լ���д��Ҳ���Լ�Ĭ�ϼ���  ������ʽ��
 * 1��ȫ�ֳ�����public static final
 * 2�����󷽷���public abstract 
 * 
 * ʹ�ýӿ� ���ü̳� ��ʵ�֣���Ϊ�ӿ���ȫ����Ҫ����
 * ��->�ࣺ�̳�		��->�ӿڣ�ʵ��
 * �ӿ��еĳ�Ա�����ǹ����ģ���Ȩ�����
 * �ӿڲ����Ա�ʵ���� ֻ����ʵ���˽ӿڵ����า�����еĳ��󷽷��󣬸�����ſ���ʵ�ֻ�
 * */

/**
 * Java��֧�ֶ�̳� ��Ϊ����ֵ��õĲ�ȷ����
 * ����̳л��Ƹ��� ��ɶ�ʵ��
 * һ�������ʵ�ֶ���ӿ�
 * 
 * һ�����ڼ̳���һ�����ͬʱ ������ʵ�ֶ���ӿ�
 * 
 * �ӿ���ӿ�֮���Ǽ̳й�ϵ�����ҿ��Զ�̳�
 * */
class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ImplementDemo iface = new ImplementDemo();
		iface.show1();
		
		System.out.println(iface.NUM);
		System.out.println(ImplementDemo.NUM);
		System.out.println(Demo.NUM);

	}

}

interface Demo{
	public static final int NUM = 10;
	public abstract void show1();
	public abstract void show2();
}

interface Demo2{
	public static final int NUM2 = 20;
	public abstract void show3();
}
class ImplementDemo implements Demo,Demo2{
	public void show1(){;
		System.out.println(this.NUM);
	}
	public void show2(){
		
	}
	public void show3(){
		
	}
}

class Fu{
	public void shouFu() {
		
	}
}


//�ӿڵĳ��� �����˵��̳о�����
class Zi extends Fu implements Demo,Demo2{
	public void show1(){;
		System.out.println(this.NUM);
	}
	public void show2(){
		
	}
	public void show3(){
		
	}	
}


interface AA{
	public abstract void aaShow();
}
interface BB{
	public abstract void bbShow();
}

interface CC extends AA,BB{
	public abstract void aaShow(){
		
	}
	public abstract void bbShow(){
			
	}
	public abstract void ccShow(){
		
	}
}

abstract class Test{
	abstract public void test();
}

//class Test2 extends Test{
//	public void test() {
//		
//	}
//}











