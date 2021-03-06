/*
 * 练习题二
 * 
 * 一个子串在整串中出现的次数
 * nbaasdanbasdfsdfnbasghjg
 * 
 * 思路：计数器+1  indexOf索引出现的位置，记录一次，在 出现的位置+要找的字符串长度  位置后在开始找
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


