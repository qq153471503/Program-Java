/**
 * @author KunGe
 *
 *		����ϰ���ġ�������ʵ��trim��������trim����
 *				 ������ȥ���ַ�����ȫ���ո�
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


