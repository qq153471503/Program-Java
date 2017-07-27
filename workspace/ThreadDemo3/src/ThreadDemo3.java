/**
 *  �� static ��Ȼ����ʵ�������̵߳����ݹ������������������������������Ʊ���Ͳ���new Ticket���������
 *  ����  �뿴��ע�͵�ʹ�÷�ʽ
 *  
 *  
 *  ��һ�֣�����һ��Thread�Ӷ����ں�static �������ݹ�����		ȱ�ݣ�����ʹ�øö�����̣߳���������һ�����ݡ�
 *  	��ƣ�һ��thread����  ���̹߳�����ͬ��ʹ��
 *  
 *  �ڶ��֣�ʵ��һ��Runnable�ӿڵ���  ����һ��Thread�̲߳���һ��ʵ����Runnable�ӿڵ����thread
 *  	��ƣ�һ��ʵ����Runnable�ӿڵ���  ����߳�ͬ��ʹ��
 *  
 *  ͬ����ǰ�᣺	1�����߳� 	2����֤���߳�ʹ�õ���һ����
 *  
 *  
 *  ͬ������
 *  �ô��� ������̵߳İ�ȫ����
 *  �׶ˣ���Խ�����Ч�ʣ���Ϊͬ������߳� �����ж�ͬ����������Ҳ�ڿɽ��ܷ�Χ��
 *  
 *  ͬ������������this �������
 *  ͬ����̬����������this.getClass ��ǰ�ֽ������
 *  ͬ�������������������
 *  ����ʹ��ͬ�������
 *  
 * */
//public class ThreadDemo3 {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Ticket t1 = new Ticket();
//		Ticket t2 = new Ticket();
//		t1.start();
//		t2.start();
//	}
//}
//
//
//
//class Ticket extends Thread{
//	
//	private static int num = 20;
//	
//	public void setNum(int num){
//		this.num = num;
//	}
//	
//	public int getNum() {
//		return this.num;
//	}
//	
//	public void sale() {
//		System.out.println(this.getName()+"..."+this.num--);
//	}
//	
//	public void run() {
//		while(true){
//			if(num > 0)
//				this.sale();
//		}
//	}
//}

public class ThreadDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Ticket tic = new Ticket();
//		
//		Thread t1 = new Thread(tic);
//		Thread t2 = new Thread(tic);
//		Thread t3 = new Thread(tic);
//		Thread t4 = new Thread(tic);
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		
		Customer c1 = new Customer();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);
		
		t1.start();
		t2.start();
		
	}
}


//�˷���ʹ�õ���ͬ�������
class Ticket implements Runnable{
	
	private int num = 20;
	Object obj = new Object();
	
	public void setNum(int num){
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void sale() {
		System.out.println(Thread.currentThread().getName()+"..."+this.num--);
	}
	
	public void run() {
		while(true){
			//ͬ�������
			synchronized (obj) {
				if(num > 0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					this.sale();
				} //end of if
			}
		}
	}// end of run
}


//�˷�ʽʹ�õ���ͬ������
//ͬ������������this �������
class Bank {
	private int sum;
	
	//ͬ������
	public synchronized void add(int num){
		this.sum += num;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("money is :"+this.sum);
	}
}

class Customer implements Runnable{
	private Bank b = new Bank();
	
	public void fun() {
		for(int x=0; x<3; x++)
			this.b.add(100);
	}
	
	public void run() {
		this.fun();
	}
}
