import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 	�� Map��ϰ�⡿�� ��ȡ�ַ����У�ÿ����ĸ���ֵĴ����������ʽ  a(2)  b(3)
 * 
 * @author KunGe
 *
 *��˼·�������ڽ���������֣��ַ��ʹ�������ӳ���ϵ�������뵽Map����Ҫ��֤�����Ψһ�� ��a-z�����ԣ�ʹ��TreeMap
 *
 *1�����ַ����������
 *2������һ��TreeMap tm ���ϣ��鿴ÿ���ַ��Ƿ������tm�У���ĸΪ��������Ϊֵ��������ڣ�
 *	ȡ����ֵ��ֵ+1���ڴ����ֵ����
 *
 */


public class zMapPriactice1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "aabbbcccddddxyz";
		char[] str_arr = str.toCharArray();
		TreeMap<Character, Integer> tm = new TreeMap<>(new CompByChar());
		
		System.out.println(function(str_arr, tm));
	}

	private static String function( char[] str_arr,
									TreeMap<Character, 
									Integer> tm) {
		
		for(int i=0; i<str_arr.length; i++){

			int count=1;		//���ֵĴ���������
			Integer val = tm.get(str_arr[i]);	//���ݼ�   ���ֵ
			
			//�ж����޸ü�ֵ  ��û�У�����ֵ��ֵ��count
			if(val != null){
				count = val+1;
			}
			
			tm.put(str_arr[i], count);
			
		}//end of for
		return mapToString(tm);
	}

	private static String mapToString(TreeMap<Character, Integer> tm) {
		
		StringBuffer sb = new StringBuffer();
		Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Character, Integer> map = it.next();
			Character key = map.getKey();
			Integer val = map.getValue();
			
			sb.append(key+"("+val+")");
		}
		return sb.toString();
	}

}


class CompByChar implements Comparator<Character>{

	@Override
	public int compare(Character o1, Character o2) {
		
		return o1.compareTo(o2);
	}
	
}