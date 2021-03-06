import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 	【 Map练习题】： 获取字符串中，每个字母出现的次数，输出格式  a(2)  b(3)
 * 
 * @author KunGe
 *
 *【思路】：对于结果分析发现，字符和次数存在映射关系，可联想到Map，需要保证有序的唯一性 从a-z，所以，使用TreeMap
 *
 *1、将字符串变成数字
 *2、创建一个TreeMap tm 集合，查看每个字符是否存在于tm中，字母为键，次数为值，如果存在，
 *	取出键值，值+1，在存入键值覆盖
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

			int count=1;		//出现的次数技计数
			Integer val = tm.get(str_arr[i]);	//根据键   获得值
			
			//判断有无该键值  若没有，将键值赋值给count
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
