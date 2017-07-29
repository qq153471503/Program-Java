/**
 * 
 * @author KunGe
 *
 *	StringBUffer : 字符缓冲区
 *	特点：
 *		1、长度可变
 *		2、可存储不同类型
 *
 *
 */
public class API_StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//
//		bufferMethodDemo();
//		int k = 2464651;
//		Integer.toBinaryString(k);
//		System.out.println(Integer.toBinaryString(k));
//		System.out.println(Integer.toString(k));
//		
//		String str = "943210";
//		System.out.println(String.valueOf(str));
//		System.out.println(Integer.parseInt(str));
//		
//		
//		int num = 4;
//		Integer i = 4;
//		System.out.println(num==i);
		
		Integer a = new Integer(128);
		Integer b = new Integer(128);
		
		System.out.println(a==b);		//false
		System.out.println(a.equals(b));//true
		
		Integer i = 127;
		Integer k = 127;
		System.out.println(i==k);				//true
		System.out.println(i.equals(k));		//true
		
		/**
		 * 观察结果，原因：  jdk1.5之后，自动装箱，如果集装箱的是一个字节(-128~127),
		 * 			     那么该数据被共享，公用一个地址，所以上面的为trun
		 */
		
		Integer x = 128;
		Integer y = 128;
		System.out.println(x==y);				//false
		System.out.println(x.equals(y));		//true
	}

	public static void bufferMethodDemo() {
		StringBuffer sb = new StringBuffer();

		StringBuffer s1 = sb.append(4);
		
		System.out.println(sb);
		System.out.println(s1);
		System.out.println(s1==sb);
		
		sb.append(true);
		System.out.println(sb);
		sb.append(100).append(false).append("asdadsa");
		System.out.println(sb);
		System.out.println(sb.reverse());
	}
}





