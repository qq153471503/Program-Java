/**
 * @author KunGe
 *
 *    【练习题三】
 *    
 *    两个字符串中，最大相同的子串
 *    例如：
 *    	字符串		AzzzzBcccc
 *    	字符串		AzzzzMkkkk
 *    
 *    最大相同： Azzzz
 *    
 *    思路： 先拿短的串在长串中找，找到直接返回，如若找不到，短串减一继续查找
 */
public class API_StringDemoPractice3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = findMaxSameSubString("zxcvb", "zxcvb");
		System.out.println(str);
	}

	public static String findMaxSameSubString(String s1, String s2) {
		String longStr = s1;
		String shortStr = s2;
		
		if(s1.length() != s2.length()){
			 longStr = s1.length()>s2.length()?s1:s2;
			 shortStr = s1.length()<s2.length()?s1:s2;
		}
		
		String tmp = new String();
		for(int x=0; x<shortStr.length(); x++){
			
			for(int y=0,z=shortStr.length()-x; z!=shortStr.length()+1; y++,z++){
				
				tmp = shortStr.substring(y, z);
				if(longStr.contains(tmp))
					return tmp;
			}
		}
		return null;
	}
}

