/**
 * ������Ϊ�������ķ�ʽ
 * �Զ����쳣ʱ Ҫô�̳�Exception Ҫô�̳�RuntimeException
 * ��������ǰ�����ڱ���ʱ�׳��쳣 ���Ӿ���Ҫ����throws ��������
 * 
 * throws�Ƿ��������׳��쳣��������(������������ʱ����ʾ�÷�������Ҫ�׳��쳣)
 * �﷨��[(���η�)](����ֵ����)(������)([�����б�])[throws(�쳣��)]{......}
            public void doA(int a) throws Exception1,Exception3{......}
   
   throw����ȷĳ���ط��׳��쳣
   
 throw������ڷ������ڣ���ʾ�׳��쳣���ɷ������ڵ���䴦����
throws������ڷ����������棬��ʾ���׳��쳣���ɸ÷����ĵ�������������

 * throw��throws���� ����ʹ���ں����� �׳������쳣�� ���ҿ����׳������ǰ��ʹ���ں����� �׳������쳣���� �Դ�ֻ��[����]һ��
 * 
 * 
 * ���า�Ǹ��ֻ࣬���׳����෽���쳣���Ӽ� �縸���з����׳�A B C�����쳣�࣬�����еĸ��Ƿ������׳����쳣 ֻ����A B C�еġ�
 * 
 * ������û�����쳣�������з����ڸ���ʱ���������쳣
 * 
 * */


//�˶δ�����ͣ� �����з����׳����쳣�ֻ࣬���Ǹ������쳣���������   
// ����Zi() ���еķ���show����ֻ���׳�A�쳣��    ����A�쳣�������B��Ҳ���Բ���
//class A extends Exception{
//	
//}
//class B extends A{
//	
//}
//
//class C extends Exception{
//	
//}
//
//class Fu {
//	void show() throws A{
//		
//	}
//}
//
//class Zi extends Fu{
//	void show() throws A{
//		
//	}
//}


public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NegativeException{
		// TODO Auto-generated method stub

		int[] arr = new int[3];
		Demo d = new Demo();
		d.method(arr, -10);
	}
}




//�Զ����쳣��
class NegativeException extends Exception{
	 NegativeException() {
		// TODO Auto-generated constructor stub
	}
	 
	 NegativeException(String msg) {
		 super(msg);
	 }
}


//
class Demo{
	public void method(int[] arr, int index) throws NegativeException {
		
		if(index < 0)
			throw new NegativeException("����Ǳ겻��Ϊ�Ǹ�����");
	}
}









