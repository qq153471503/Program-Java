
/**
 * wait()	:	ʹ�̴߳��ڶ���״̬��ͬʱ�ͷ�ִ��Ȩ��ִ���ʸ񣬱�wait���̻߳ᱻ�洢���̳߳���
 * notify() :	�����̳߳��е�һ���̣߳����⣩
 * notifyAll(): �����̳߳��ж��е��̣߳�ʹ��������������״̬�����仰˵����ʹ�̳߳��е������߳̾߱�ִ���ʸ�
 * */

public class ThreadCommunicationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource r = new Resource();
		Input in = new Input(r);
		Ouput ou = new Ouput(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(ou);
		
		t1.start();
		t2.start();
	}

}


class Resource{
	private String name=null;
	private String sex=null;
	public boolean flag = false;
	
	public synchronized void set(String name, String sex) {
		if(flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.name = name;
		this.sex = sex;
		this.flag = true;
		this.notify();
	}
	
	public synchronized void show() {
		if(!this.flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name+"..."+this.sex);
		this.flag = false;
		this.notify();
	}
}


class Input implements Runnable{
	
	Resource r;
	Input(Resource r) {
		this.r = r;
	}
	public void run() {
		boolean flag = true;
		while(true){
				
				if(flag){
					r.set("mike", "nv");
				}
				else {
					r.set("С��", "������������");
				}
				flag = !flag;
			}//end of while
		}
	
}//end of class Input

class Ouput implements Runnable{
	
	Resource r;
	
	Ouput(Resource r){
		this.r = r;
	}
	
	public void run() {
		
		while(true){
			r.show();
		}// end of while
	}
}

