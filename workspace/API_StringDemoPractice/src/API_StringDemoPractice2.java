/*
 * ��ϰ���
 * 
 * һ���Ӵ��������г��ֵĴ���
 * nbaasdanbasdfsdfnbasghjg
 * 
 * ˼·��������+1  indexOf�������ֵ�λ�ã���¼һ�Σ��� ���ֵ�λ��+Ҫ�ҵ��ַ�������  λ�ú��ڿ�ʼ��
 * 
 * **/
public class API_StringDemoPractice2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "aaaBBBaaaCCCaaaDDDaaaFFF";
		System.out.println(find(str, "aaa"));
	}

	/**
	 * 
	 * @param str
	 * @param key
	 * @return
	 */
	private static int find(String str, String key) {
		int count=0;
		while(str.indexOf(key) != -1){
			count++;
			str = str.substring(str.indexOf(key)+key.length());
		}
		return count;
	}
}

