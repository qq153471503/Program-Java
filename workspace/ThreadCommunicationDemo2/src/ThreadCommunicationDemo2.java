/*


���ʹ��notify ������ʹ�� notifyAll ������ֳ�������  �������£�
0 1 wait��

2 ����0��   ��Ϊ��while(true) r.show(); 2->wait
3 wait

0 true (1 2 3)�л���1 ��Ϊ��while(true) r.set() 0-wait

1 ->wait

����ȫ��wait  ��������


while�жϱ�ǣ�������̻߳�ȡִ��Ȩ���Ƿ�Ҫ���У�
notifyAll����ˣ�һ���ỽ�ѶԷ����߳�

if�жϱ�ǣ�ֻ��һ�Σ��ᵼ�²������е��߳����У��������ݴ�������
notifyֻ����һ���߳� ��������˱�����û�����塣

��while+notify�ᵼ�³�������

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
		System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
	
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

		System.out.println(Thread.currentThread().getName()+"........������.."+this.name);
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
