import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*

JDK1.5 ������   

��ͬ���� ��װ���˶���

wait �� sleep����

1��wait����ָ��ʱ�䣬Ҳ���Բ�ָ��  sleep����ָ��ʱ��
2����ͬ����ʱ����cpu��ִ��Ȩ�����Ĵ�����ͬ
	wait �ͷ�ִ��Ȩ���ͷ���
	sleep �ͷ�ִ��Ȩ �����ͷ���
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
			System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
		
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
			
			System.out.println(Thread.currentThread().getName()+"........������.."+this.name);
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
			r.set("��Ѽ");
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
