/**
 * �����߳̽�����ʽ һ
 * �����־  ����Щʱ�� �޷�ֹͣ�߳� ��δע�ʹ���
 * */
//public class ThreadCommunicaitonDemo4 {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		
//		Demo d = new Demo();
//		Thread t1 = new Thread(d);
//		Thread t2 = new Thread(d);
//		t1.start();
//		t2.start();
//		
//		int cnt=0;
//		for(;;){
//			if(cnt++ == 50){
//				d.setFlag(false);
//				break;
//			}
//			System.out.println("main"+cnt);
//		}
//
//		System.out.println("over...");
//	}
//
//}
//
//
//class Demo implements Runnable{
//	
//	private boolean flag = true;
//	public void run() {
//		
//		while(flag) {
//			System.out.println(Thread.currentThread().getName()+"...run");
//		}
//	}
//	
//	public void setFlag(boolean flag) {
//		this.flag = flag;
//	}
//}


/**
 * �߳����ʹ�õ�ͬ��  �ͻ����wait״̬�����߳�ִ�����֮��
 * �����߳̾ͻ�����ȴ�״̬����û��ֹͣ ����ʹ��interrupt����ǿ�ƻ��ѣ�
 * ʹ���߳̾���cpu��ִ���ʸ�
 * 
 * ע�����ǿ�ƻ���֮�󣬼ǵ�Ҫ��catch�д��� ���籾demo
 * 
 * ������ʹ���ػ��̣߳� �������ػ��߳�ʱ��JVM���˳���  �ػ�������start�߳�ǰ���� 
 * �磺t2.interruptע�͵�  ��t2.startǰ  ��t2����Ϊ�ػ��߳�  main���̽�����JVM�����˳�
 * 
 * �ػ��߳�->��̨�߳�
 * 
 * ǰ̨�߳� �� ��̨�߳�����ʱ һ����ֻ���˳���ʱ��ǰ̨�̱߳����ֶ��˳�
 * �����ں�̨�̣߳�����ǰ̨�̶߳������ˣ����۴���ʲô״̬���Զ�����
 * 
 * */
public class ThreadCommunicaitonDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		t2.setDaemon(true);  //����Ϊ��̨����
		t2.start();
		
		int cnt=0;
		for(;;){
			if(cnt++ == 50){
//				d.setFlag(false);
				t1.interrupt();
//				t2.interrupt();
				break;
			}
			System.out.println("main.."+cnt);
		}

		System.out.println("over...");
	}

}


class Demo implements Runnable{
	
	private boolean flag = true;
	
	public synchronized void run() {
		
		while(flag) {
			try{
				this.wait();

			}catch (InterruptedException e) {
				
				//interrupt����֮�� �ڴ˴��������У���flag��Ϊfalse
				this.flag = false;
				
				System.out.println(Thread.currentThread().getName()+"..."+e);
			}
			
			System.out.println(Thread.currentThread().getName()+"...run++++");
		}
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
