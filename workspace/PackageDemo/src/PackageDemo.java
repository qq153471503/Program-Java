//import mypack1.Demo;

/**
 * Jar文件：java的压缩包
 * dos工具
 * */
import org.omg.CORBA.PUBLIC_MEMBER;

import mypack2.*;

public class PackageDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Package demo !!");

		Demo2 demo2 = new Demo2();
		demo2.show();
		
		Inter in = new Inter() {
			
			@Override
			public void show() {
				
			}
			
			@Override
			public void fun() {
				// TODO Auto-generated method stub
				
			}
		};
		
		show(new Inter() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fun() {
				// TODO Auto-generated method stub
				System.out.println("123");
			}
		});

	} //end of main

	
	public  static void show(Inter in){
		in.fun();
	}
}



interface Inter{
	abstract public void show();
	abstract public void fun();
}



