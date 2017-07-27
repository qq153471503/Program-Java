/**
 * ������Ϊ��׽�쳣������ʽ�����ǿ��Խ�������Դ����ķ�ʽ
 * �����ʽ��
 * try{//����
 * 		//��Ҫ�������쳣
 * }
 * catch(�쳣�� ����)�� //���� �������ǽ��յ�ǰ�������쳣����
 * 		//�����쳣�Ĵ���
 * ��
 * finally{ //���ջ�
 * 		//һ���ᱻִ�еĴ���
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
			ne.printStackTrace(); //jvmĬ�ϵ��쳣�������ƾ��ǵ����쳣����ķ���
			
		} catch (Array2BigException ae) {
			
			ae.printStackTrace();
			
		} catch (Exception e) {  //�˴�ע�⣡ ��catchʱ ����Exceptionһ��Ҫ������� �������ڶ�̬��ԭ�򣬱���ʧ�ܣ�������catch�ȷϻ����ϻ�
			
			e.printStackTrace();
		}
		
		System.out.println("Application run over ����");
		
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
			throw new ArrayNegativeException("����Ǳ겻��Ϊ������");
		if(arr == null)
			throw new ArrayNegativeException("����Ԫ��Ϊ�գ�");
		if(index > (int)(1024))		//����������4096�ֽ�
			throw new Array2BigException("Array is too big !");
		return arr[index];
	}
}















