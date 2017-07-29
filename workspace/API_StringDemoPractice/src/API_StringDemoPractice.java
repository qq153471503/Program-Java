
public class API_StringDemoPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun();
	}

	private static void fun() {

		/*
		 * 给定一个字符数组  按照字典顺序排序
		 * */
		/*
		 * 思路：
		 * 1、对数组排序，可以用选择 冒泡等
		 * 2、for嵌套 比较 在换位
		 * */
		
		String str[] = {"def","abc","xyz","ghi"};
		printArray(str);
		sort(str);
		printArray(str);
		
	}


	private static void sort(String[] str) {

		String tmp;
		
		for (int i = 0; i < str.length-1; i++) {
			if(str[i].compareTo(str[i+1]) > 0){

				tmp = str[i];
				str[i] = str[i+1];
				str[i+1] = tmp;
			}
		}
	}

	private static void printArray(String[] str) {

		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println();
	}




}
