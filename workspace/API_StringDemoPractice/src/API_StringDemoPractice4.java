/**
 * @author KunGe
 *
 *		【练习题四】：自行实现trim方法，在trim方法
 *				 基础上去除字符串的全部空格
 *
 */
public class API_StringDemoPractice4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = new String(" a b c d f g ");
		
		String tmp = removeStringSpace(str);
		
		System.out.println(tmp);
	}

	private static String removeStringSpace(String str) {
		String tmp="";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' '){
				tmp += str.charAt(i);
			}
		}//end of for
		
		return tmp;
	}

}


