/**
 * 1�������಻�ܱ�ʵ����
 * 2�����󷽷�ֻ���ڳ�������
 * 3������������������า�����еĳ��󷽷���������ſ���ʵ��������������໹�ǳ�����
 * 4��abstract�����Ժ�private���棬��Ϊ���󷽷���Ҫ������
 *    		 �����Ժ�static���棬ԭ��static���εķ�����������ڳ������������塣
 *    		�����Ժ�final���� ԭ��final���κ�������˷�������abstract�ɶ�����ϵ
 * */
public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b = new B();
		b.show();
		b.sleep();
	}

}

//������
abstract class A{
	//������
	abstract public void show();
	
	public void sleep(){
		System.out.println("Sleeping.....");
	}
}

class B extends A{
	
	public void show(){
		System.out.println("BBBBBB");
	}
}

