/**
 * 死锁Demo
 * 
 * 出现的原因：同步嵌套
 * */
public class ThreadDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test a = new Test(true);
		Test b = new Test(false);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t1.start();
		t2.start();
	}

}

class MyLock{
	public static final Object loch_a = new Object();
	public static final Object loch_b = new Object();
}

class Test implements Runnable{
	private boolean flag;
	Test(boolean flag) {
		this.flag = flag;
	}
	
	public void run() {
		if(flag){
			synchronized (MyLock.loch_a) {
				
				System.out.println("if lock..a");
				
				synchronized (MyLock.loch_b) {
					
					System.out.println("if lock..b");
				}
			}
		}else {
			synchronized (MyLock.loch_b) {

				System.out.println("else  lock..b");
				synchronized (MyLock.loch_a) {
					
					System.out.println("else  lock..a");
				}
			}
		}
	}
}


