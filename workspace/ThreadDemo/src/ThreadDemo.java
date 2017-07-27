
public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		new TheMain("����").run();
		Secondary s1 = new Secondary("����");
		Secondary s2 = new Secondary("xiaoqing");
		
		s1.start();
		s2.start();
		
		System.out.println("over");
		System.out.println(s1.getId());
		System.out.println(s2.getId());
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		
	}

}



class Secondary extends Thread{
	
	private String name;
	
	Secondary(String name){
		this.name = name;
	}
	public void run() {
		this.work();
	}
	
	private void work(){
		for(int y=0; y<=10; y++)
		{
			System.out.println("y="+y+"...name:"+this.name);
		}
	}
}


class TheMain{
	private String name;
	
	TheMain(String name){
		this.name = name;
	}
	
	public void run(){
		for(int x=0; x<10; x++)
			System.out.println("x="+x+"...name:"+this.name);
	}
}


