/*


如果使用notify 而不是使用 notifyAll 将会出现程序死锁  分析如下：
0 1 wait后

2 唤醒0后   因为有while(true) r.show(); 2->wait
3 wait

0 true (1 2 3)中唤醒1 因为有while(true) r.set() 0-wait

1 ->wait

到此全部wait  程序死锁


while判断标记，解决了线程获取执行权后，是否还要运行！
notifyAll解决了，一定会唤醒对方的线程

if判断标记，只有一次，会导致不该运行的线程运行，出现数据错误的情况
notify只唤醒一个线程 如果唤醒了本方，没有意义。

而while+notify会导致程序死锁

*/
public class ThreadCommunicationDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource r = new Resource();
		Producers pd = new Producers(r);
		Consumers con = new Consumers(r);
		
		Thread t0 = new Thread(con);
		Thread t1 = new Thread(con);
		Thread t2 = new Thread(pd);
		Thread t3 = new Thread(pd);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}


class Resource{
	private String name;
	private int count=1;
	private boolean flag = false;
	
	public synchronized void set(String name) {
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end of if(flag)

		this.name = name + this.count;
		this.count++;
		System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
	
		this.flag = true;
		this.notifyAll();
	}
	
	public synchronized void show(){
		while(!this.flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName()+"........消费者.."+this.name);
		this.flag = false;
		this.notifyAll();
	}
}

class Producers implements Runnable{
	private Resource r;
	
	Producers(Resource r){
		this.r = r;
	}
	
	public void run() {
		while(true)
			r.set("烤鸭");
	}
}

class Consumers implements Runnable{
	private Resource r;
	
	Consumers(Resource r){
		this.r = r;
	}
	
	public void run() {
		while(true)
			r.show();
	}
}

