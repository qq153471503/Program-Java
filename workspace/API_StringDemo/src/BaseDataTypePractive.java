import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author KunGe
 *
 * 对一个字符串中的数据进行排序
 *  "20 78 -2 50 -69 100 28"
 *
 *
 *	思路：
 *		1、都有空格  那就用切割，分成独立的多个小串
 *		2、将小串转换成int型
 *		3、排序
 */
public class BaseDataTypePractive {

	private static final String space = " ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "20 78 -2 50 -69 100 28";
		String[] str_arr = string2StringArray(str);
		int[] arr = strArr2intArr(str_arr);
		Arrays.sort(arr);
		forEachIntArr(arr);
		
	}

	public static String[] string2StringArray(String str) {
		String[] s = str.split(" ");
		return s;
	}
	
	public static int[] strArr2intArr(String[] strArr) {
		int[] tmp = new int[strArr.length];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = Integer.parseInt(strArr[i]);
		}
		
		return tmp;
	}
	
	public static void forEachIntArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}




