/**
 * 
 * @author KunGe
 *
 *	StringBUffer : �ַ�������
 *	�ص㣺
 *		1�����ȿɱ�
 *		2���ɴ洢��ͬ����
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
		 * �۲�����ԭ��  jdk1.5֮���Զ�װ�䣬�����װ�����һ���ֽ�(-128~127),
		 * 			     ��ô�����ݱ���������һ����ַ�����������Ϊtrun
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





