/**
 * 控制线程结束方式 一
 * 定义标志  在有些时候 无法停止线程 看未注释代码
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
 * 线程如果使用到同步  就会进入wait状态，主线程执行完毕之后，
 * 其他线程就会陷入等待状态，并没有停止 可以使用interrupt方法强制唤醒，
 * 使该线程具有cpu的执行资格
 * 
 * 注意事项：强制唤醒之后，记得要在catch中处理 例如本demo
 * 
 * 还可以使用守护线程， 当都是守护线程时，JVM将退出。  守护必须在start线程前设置 
 * 如：t2.interrupt注释掉  在t2.start前  将t2设置为守护线程  main进程结束后，JVM依旧退出
 * 
 * 守护线程->后台线程
 * 
 * 前台线程 和 后台线程运行时 一样，只是退出的时候前台线程必须手动退出
 * 而对于后台线程，所有前台线程都结束了，无论处于什么状态都自动结束
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
		t2.setDaemon(true);  //设置为后台进程
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
				
				//interrupt唤醒之后 在此处继续运行，将flag置为false
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

