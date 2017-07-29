/**
 * String�� �ص�
 * 1���ַ�������һ���������Ͳ��ᱻ�ı�
 * 
 * 
 * 
 * 
 * */
public class API_StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		stringDemo1();
//		stringDemo2();
		
//		stringConstructDemo2();
		
//		stringMethodDemo1();
//		stringMethodDemo2();
//		stringMethodDemo3();
//		stringMethodDemo4();
		stringMethodDemo5();
	}

	private static void stringMethodDemo5() {

	//�����ַ����淶������ʽ
		//intern���� ���Զ��ַ����ز���
		String s = new String("ABC");
		String s1 = s.intern();
		System.out.println(s1);
		System.out.println(s1==s);
	}

	private static void stringMethodDemo4() {
		
	//�ַ����Ƚ�
		System.out.println("abcde".compareTo("ABCDE")); //����ASCII˳��Ƚ�   ���Ǵ�Сд
		System.out.println("abcde".compareToIgnoreCase("ABCDE")); //�����Ǵ�Сд
	}

	private static void stringMethodDemo3() {

	//�ַ����ж�
		String s = "abc";
		System.out.println(s.equals("ABC"));
		System.out.println(s.equalsIgnoreCase("abc"));	//���Դ�Сд�Ƚ�
		
	//�ַ������Ƿ����
		String s1 = "abcdef";
		System.out.println(s1.contains("z"));
		
	//�Ƿ���ָ���ַ�����ͷ&��β
		System.out.println("abc".startsWith("a"));
		System.out.println("abc".endsWith("c"));
	}

	private static void stringMethodDemo2() {
		String str = "һ,��,��,��,��";
		String[] arr = str.split(",");		//�ַ����и�
		
		for(int x=0; x<arr.length; x++)
			System.out.print(arr[x]);
		
		System.out.println();
		
		char[] ch = str.toCharArray();
		for(int x=0; x<ch.length; x++)
			System.out.print(ch[x]);
		System.out.println(ch.length);
		
//		String s = "ab��";
//		byte[] by = s.getBytes();
//		for (int i = 0; i < ch.length; i++) {
//			System.out.println(by[i]);
//		}
		
		//ת���ɴ�д
		System.out.println("AAAnnn".toUpperCase());
		System.out.println("BBBBBB".toLowerCase());
		
		//ȥ����β�ո�
		System.out.println(" J a v a ".trim());
		
		//�ַ����е��ַ��滻   ���δ�ҵ��� ���Ϊԭ�ַ���
		System.out.println("ABcDE".replace('c','C'));
		
		String s3 = "java";
		String s4 = s3.replace('b', 'c');
		System.out.println(s3==s4);
		
		//�ַ�������
		System.out.println("abc".concat("defghi"));
		
	}

	private static void stringMethodDemo1() {
		char[] arr = new char[10];
		for(char x=97,y=0; x<97+arr.length; x++,y++)
			arr[y] = x;
		String str = new String(arr);
		System.out.println(str.length());
		
		char[] arr2 = new char[10];
		str.getChars(0, 5, arr2, 0);
		System.out.println(arr2);
		
		String str2 = new String("zxcvbnmc");
		System.out.println("char is : "+str2.charAt(0));
		System.out.println("String at : "+str2.indexOf("nm"));
		System.out.println("char at : "+str2.indexOf('n'));
		System.out.println("char 'c' at : "+str2.indexOf('c', str2.indexOf('c')+1));
		System.out.println("sub String is : "+str2.substring(2, 5));
		
	}

	private static void stringConstructDemo2() {
		
		char[] arr = {'a','b','c','d','e'};
		char[] arr2={'1','2','3','4','5'};
		String s = new String(arr);
		System.out.println(s);
		System.out.println(new String(arr2,0,3));
	}

	private static void stringConstructDemo1() {
		String s = new String(); 
		//��Ч��String s="";  ����Ч��String s=null;
		//ǰ���ǿ��ַ���������null����
		
		byte[] arr = {97,98,99,100,101};
		String s1 = new String(arr);
		System.out.println(s1);
		
	}

	private static void stringDemo2() {

		String s = new String("abc");
		String s2 = new String("abc");
		
		System.out.println(s==s2);
		/*
		 * ���Ϊfalse
		 * ��Ϊ������������ֱ�ӱȽϵ��ǵ�ַ
		 * **/
		
		System.out.println(s.equals(s2));
		/*
		 * ���Ϊtrue
		 * ��Ϊequals�Ƚϵ��������ص㣬˵���˾��ǱȽϵ�����
		 * String�е�euqals��дObject�еģ�
		 * �Ƚ��ַ�������
		 * **/
	}

	private static void stringDemo1() {
		/**
		 * �˴�strֻ������  ��һ��ָ��abc���� �ڶ���ָ��def����
		 * */
		String str = "abc";
//		str = "abc";
		
		String str1 = "abc";
		System.out.println(str1==str);
		
		/*
		 * ���Ϊ�棺��Ϊ�ڻ�����У����abc�Ѿ��������ͻὫ�õ�ַ��ֵ�����á�
		 * ������������ǹ����ġ�
		 * */
	}

}

