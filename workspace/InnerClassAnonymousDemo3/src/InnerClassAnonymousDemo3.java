

class Outer{
	public void method() {
		Object obj = new Object(){
			public void show() {
				System.out.println("outer...show1..run");
			}
		};
		
		//������ʵ��������ʽ  ��Ϊ����Object obj = new Object()����
		//��̬�������ڲ����� ������� obj����ת��ΪObject���ͣ��������ò���show������
//		obj.show();
		
		//�����ַ���ȴ���ԣ�
//		new Object(){
//			public void show(){
//				System.out.println("outer...show1..run");
//			}
//		}.show();
	}
}
public class InnerClassAnonymousDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Outer().method();
	}

}
