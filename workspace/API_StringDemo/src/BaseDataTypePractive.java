import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author KunGe
 *
 * ��һ���ַ����е����ݽ�������
 *  "20 78 -2 50 -69 100 28"
 *
 *
 *	˼·��
 *		1�����пո�  �Ǿ����и�ֳɶ����Ķ��С��
 *		2����С��ת����int��
 *		3������
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




