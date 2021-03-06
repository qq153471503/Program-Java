/**
 * String类 特点
 * 1、字符串对象一旦被建立就不会被改变
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

	//返回字符串规范表现形式
		//intern方法 可以对字符串池操作
		String s = new String("ABC");
		String s1 = s.intern();
		System.out.println(s1);
		System.out.println(s1==s);
	}

	private static void stringMethodDemo4() {
		
	//字符串比较
		System.out.println("abcde".compareTo("ABCDE")); //按照ASCII顺序比较   考虑大小写
		System.out.println("abcde".compareToIgnoreCase("ABCDE")); //不考虑大小写
	}

	private static void stringMethodDemo3() {

	//字符串判断
		String s = "abc";
		System.out.println(s.equals("ABC"));
		System.out.println(s.equalsIgnoreCase("abc"));	//忽略大小写比较
		
	//字符串中是否包含
		String s1 = "abcdef";
		System.out.println(s1.contains("z"));
		
	//是否以指定字符串开头&结尾
		System.out.println("abc".startsWith("a"));
		System.out.println("abc".endsWith("c"));
	}

	private static void stringMethodDemo2() {
		String str = "一,二,三,四,五";
		String[] arr = str.split(",");		//字符串切割
		
		for(int x=0; x<arr.length; x++)
			System.out.print(arr[x]);
		
		System.out.println();
		
		char[] ch = str.toCharArray();
		for(int x=0; x<ch.length; x++)
			System.out.print(ch[x]);
		System.out.println(ch.length);
		
//		String s = "ab你";
//		byte[] by = s.getBytes();
//		for (int i = 0; i < ch.length; i++) {
//			System.out.println(by[i]);
//		}
		
		//转换成大写
		System.out.println("AAAnnn".toUpperCase());
		System.out.println("BBBBBB".toLowerCase());
		
		//去除首尾空格
		System.out.println(" J a v a ".trim());
		
		//字符串中的字符替换   如果未找到找 结果为原字符串
		System.out.println("ABcDE".replace('c','C'));
		
		String s3 = "java";
		String s4 = s3.replace('b', 'c');
		System.out.println(s3==s4);
		
		//字符串连接
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
		//等效：String s="";  不等效：String s=null;
		//前者是空字符，后者是null常量
		
		byte[] arr = {97,98,99,100,101};
		String s1 = new String(arr);
		System.out.println(s1);
		
	}

	private static void stringDemo2() {

		String s = new String("abc");
		String s2 = new String("abc");
		
		System.out.println(s==s2);
		/*
		 * 结果为false
		 * 因为这是两个对象，直接比较的是地址
		 * **/
		
		System.out.println(s.equals(s2));
		/*
		 * 结果为true
		 * 因为equals比较的是自身特点，说白了就是比较的内容
		 * String中的euqals覆写Object中的，
		 * 比较字符串内容
		 * **/
	}

	private static void stringDemo1() {
		/**
		 * 此处str只是引用  第一次指向abc对象 第二次指向def对象
		 * */
		String str = "abc";
//		str = "abc";
		
		String str1 = "abc";
		System.out.println(str1==str);
		
		/*
		 * 结果为真：因为在缓冲池中，如果abc已经建立，就会将该地址赋值给引用。
		 * 缓冲池中数据是共享的。
		 * */
	}

}


