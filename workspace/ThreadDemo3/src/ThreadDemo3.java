/**
 *  用 static 虽然可以实现两个线程的数据共享，但是如果还有另外两个窗口卖票，就不能new Ticket这个对象了
 *  所以  请看非注释的使用方式
 *  
 *  
 *  第一种：创建一个Thread子对象，内含static 用于数据共享。		缺陷：所有使用该对象的线程，都将共享一个数据。
 *  	简称：一个thread子类  多线程共享并同步使用
 *  
 *  第二种：实现一个Runnable接口的类  创建一个Thread线程并将一个实现自Runnable接口的类给thread
 *  	简称：一个实现自Runnable接口的类  多个线程同步使用
 *  
 *  同步的前提：	1、多线程 	2、保证多线程使用的是一个锁
 *  
 *  
 *  同步锁：
 *  好处： 解决了线程的安全问题
 *  弊端：相对降低了效率，因为同步外的线程 都会判断同步锁，不过也在可接受范围内
 *  
 *  同步函数的锁：this 本类对象
 *  同步静态函数的锁：this.getClass 当前字节码对象
 *  同步代码块的锁：任意对象
 *  建议使用同步代码块
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


//此方法使用的是同步代码块
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
			//同步代码块
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


//此方式使用的是同步函数
//同步函数的锁：this 本类对象
class Bank {
	private int sum;
	
	//同步函数
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

