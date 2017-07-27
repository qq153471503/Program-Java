
public class ThreadDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread t1 = new Thread(new Demo(), "demo");
		t1.start();
		
		Thread t2 = new Thread(new Demo(), "demo2");
		t2.start();
	}

}


class Demo implements Runnable{
	public void run() {

		this.show();
		System.out.println("name is : "+Thread.currentThread().getName());
	}
	
	private void show(){
		for(int i=0; i<10; i++)
			System.out.println("i : "+i);	
	}
}


