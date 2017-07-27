import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*

JDK1.5 新特性   

将同步锁 封装成了对象

wait 和 sleep区别：

1、wait可以指定时间，也可以不指定  sleep必须指定时间
2、在同步中时，对cpu的执行权和锁的处理不同
	wait 释放执行权，释放锁
	sleep 释放执行权 ，不释放锁
*/
public class ThreadCommunicationDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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
	
	final Lock lock = new ReentrantLock();
	final Condition l_consumers  = lock.newCondition(); 
	final Condition l_producers = lock.newCondition(); 

	public void set(String name) {
		lock.lock();
		
		try {
			
			while(flag){
				try {
					this.l_consumers.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//end of if(flag)
			
			this.name = name + this.count;
			this.count++;
			System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
		
			this.flag = true;
			this.l_producers.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	public  void show(){
		
		lock.lock();
		try{
			while(!this.flag){
				try {this.l_producers.await();}
				catch(InterruptedException e){e.printStackTrace();}
			}
			
			System.out.println(Thread.currentThread().getName()+"........消费者.."+this.name);
			this.flag = false;
			this.l_consumers.signal();
			
		}finally {
			lock.unlock();
		}
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

