import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class MapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		method3(map);
	}
	
	/*
	 * 第二种去处方式
	 */
	private static void method3(Map<Integer, String> map) {
		map.put(10001, "李强");//添加
		map.put(10002, "王明");
		map.put(10003, "周花");//删除元素李明
		
		Set<Map.Entry<Integer, String>> es = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = es.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			String name = me.getValue();
			Integer in = me.getKey();
			System.out.println(name+in);
		}
		
		
		
		Collection<String> vals = map.values();
		Iterator<String> it2 = vals.iterator();
		while(it2.hasNext()){
			System.out.println("....."+it2.next());
		}
	}

	/*
	 * 第一种取出方式
	 */
	public static void method2(Map<Integer, String> map) {
		map.put(10001, "李强");//添加
		map.put(10002, "王明");
		map.put(10003, "周花");//删除元素李明
		
		Set<Integer> lhs = map.keySet();
		Iterator<Integer> it = lhs.iterator();
		
		while(it.hasNext()){
			Integer key = it.next();
			String val = map.get(key);
			System.out.println(key+val);
		}
		
	}
	
	public static void method(Map<Integer, String> map) {
		
		map.put(10001, "李强");//添加
		map.put(10002, "王明");
		map.put(10002, "周花");//删除元素李明
		
		System.out.println(map);
	}
}





