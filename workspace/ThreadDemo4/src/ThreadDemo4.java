
public class ThreadDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//����ʽ :�������ģʽ  �̰߳�ȫ
class Single{
	private static final Single sg = new Single();
	private Single(){
		
	}
	
	public static Single getInstance(){
		return sg;
	}
}


//����ʽ�� �ӳټ������ģʽ �õ������ʱ���ڼ���   �̲߳���ȫ
//class Single2{
//	private static Single2 s = null;
//	private Single2(){
//		
//	}
//	
//	public static Single2 getInstance(){
//		if(s == null)
//			s = new Single2();
//		return s;
//	}
//}

//��д��ʽ1  ͬ��������ÿ��ÿ���̶߳���Ҫ��֤�� Ч�ʵ�
//class Single2{
//	private static Single2 s = null;
//	private Single2(){
//		
//	}
//	
//	public static synchronized Single2 getInstance(){
//		if(s == null)
//			s = new Single2();
//		return s;
//	}
//}

//�ĵķ�ʽ2  ͬ�������
class Single2{
	private static Single2 s = null;
	private Single2(){
		
	}
	
	public static Single2 getInstance(){
		if(s == null)
		{
			synchronized(Single2.class) //������getClass�������  ���ǷǾ�̬��
			{
				if(s == null)
					s = new Single2();
			}
		}
		return s;
	}
}


