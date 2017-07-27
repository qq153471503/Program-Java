/**
 * 该例程为：声明的方式
 * 自定义异常时 要么继承Exception 要么继承RuntimeException
 * 两者区别：前者是在编译时抛出异常 在子句上要声明throws 后者无需
 * 
 * throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)
 * 语法：[(修饰符)](返回值类型)(方法名)([参数列表])[throws(异常类)]{......}
            public void doA(int a) throws Exception1,Exception3{......}
   
   throw是明确某个地方抛出异常
   
 throw语句用在方法体内，表示抛出异常，由方法体内的语句处理。
throws语句用在方法声明后面，表示再抛出异常，由该方法的调用者来处理。

 * throw与throws区别： 后者使用在函数上 抛出的是异常类 而且可以抛出多个，前者使用在函数内 抛出的是异常对象 以此只能[引发]一个
 * 
 * 
 * 子类覆盖父类，只能抛出父类方法异常的子集 如父类中方法抛出A B C三个异常类，子类中的覆盖方法所抛出的异常 只能是A B C中的。
 * 
 * 父类中没有抛异常，子类中方法在覆盖时绝不能抛异常
 * 
 * */


//此段代码解释： 子类中方法抛出的异常类，只能是父类中异常类或者子类   
// 如下Zi() 类中的方法show（）只能抛出A异常类    或者A异常类的子类B，也可以不抛
//class A extends Exception{
//	
//}
//class B extends A{
//	
//}
//
//class C extends Exception{
//	
//}
//
//class Fu {
//	void show() throws A{
//		
//	}
//}
//
//class Zi extends Fu{
//	void show() throws A{
//		
//	}
//}


public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NegativeException{
		// TODO Auto-generated method stub

		int[] arr = new int[3];
		Demo d = new Demo();
		d.method(arr, -10);
	}
}




//自定义异常类
class NegativeException extends Exception{
	 NegativeException() {
		// TODO Auto-generated constructor stub
	}
	 
	 NegativeException(String msg) {
		 super(msg);
	 }
}


//
class Demo{
	public void method(int[] arr, int index) throws NegativeException {
		
		if(index < 0)
			throw new NegativeException("数组角标不能为是负数！");
	}
}










