/**
 * @author KunGe
 *
 *    ����ϰ������
 *    
 *    �����ַ����У������ͬ���Ӵ�
 *    ���磺
 *    	�ַ���		AzzzzBcccc
 *    	�ַ���		AzzzzMkkkk
 *    
 *    �����ͬ�� Azzzz
 *    
 *    ˼·�� ���ö̵Ĵ��ڳ������ң��ҵ�ֱ�ӷ��أ������Ҳ������̴���һ��������
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
