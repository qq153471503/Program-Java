/**
 * 该例程为捕捉异常处理方式，这是可以进行针对性处理的方式
 * 具体格式：
 * try{//尝试
 * 		//需要被检测的异常
 * }
 * catch(异常类 变量)｛ //捕获 括号内是接收当前发生的异常对象
 * 		//处理异常的代码
 * ｝
 * finally{ //最终化
 * 		//一定会被执行的代码
 * }
 * 
 * 
 * */
public class ExceptionDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[3];
		Demo d= new Demo();
		
		try {
			int num = d.method(arr, 1025);
			System.out.println("num"+num);
			
		} catch (ArrayNegativeException ne) {
//			System.out.println(ne.getMessage());
//			System.out.println(ne.toString());
			ne.printStackTrace(); //jvm默认的异常处理机制就是调用异常对象的方法
			
		} catch (Array2BigException ae) {
			
			ae.printStackTrace();
			
		} catch (Exception e) {  //此处注意！ 多catch时 父类Exception一定要放在最后 否则由于多态的原因，便以失败，其后面的catch比废话还废话
			
			e.printStackTrace();
		}
		
		System.out.println("Application run over ！！");
		
	}

}

class ArrayNegativeException extends Exception{
	ArrayNegativeException() {
	
	}
	
	ArrayNegativeException(String msg){
		super(msg);
	}
}

class Array2BigException extends Exception{
	Array2BigException(){
		
	}
	
	Array2BigException(String msg){
		super(msg);
	}
}

class Demo{
	public int method(int[] arr, int index) throws ArrayNegativeException, Array2BigException{
		if(index < 0)
			throw new ArrayNegativeException("数组角标不能为负数！");
		if(arr == null)
			throw new ArrayNegativeException("数据元素为空！");
		if(index > (int)(1024))		//如果数组大于4096字节
			throw new Array2BigException("Array is too big !");
		return arr[index];
	}
}
















