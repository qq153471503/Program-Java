
public class ThreadDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//饿汉式 :单例设计模式  线程安全
class Single{
	private static final Single sg = new Single();
	private Single(){
		
	}
	
	public static Single getInstance(){
		return sg;
	}
}


//懒汉式： 延迟加载设计模式 用到该类的时候在加载   线程不安全
//class Single2{
//	private static Single2 s = null;
//	private Single2(){
//		
//	}
//	
//	public static Single2 getInstance(){
//		if(s == null)
//			s = new Single2();
//		return s;
//	}
//}

//改写方式1  同步函数：每次每个线程都需要验证锁 效率低
//class Single2{
//	private static Single2 s = null;
//	private Single2(){
//		
//	}
//	
//	public static synchronized Single2 getInstance(){
//		if(s == null)
//			s = new Single2();
//		return s;
//	}
//}

//改的方式2  同步代码块
class Single2{
	private static Single2 s = null;
	private Single2(){
		
	}
	
	public static Single2 getInstance(){
		if(s == null)
		{
			synchronized(Single2.class) //不能用getClass这个方法  他是非静态的
			{
				if(s == null)
					s = new Single2();
			}
		}
		return s;
	}
}


