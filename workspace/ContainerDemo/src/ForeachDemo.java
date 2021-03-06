import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 【Foreash语句 Demo】
 * 
 * @author KunGe
 *
 */
public class ForeachDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		show();
		System.out.println(add(5,10,15,20));

		/**
		 * 【静态导入】：
		 */
		
		List<String> list = new ArrayList<>();
		
		list.add("zsad");
		list.add("oijf");
		list.add("hij");
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

	private static void show() {
		List<String> list = new ArrayList<>();
		
		list.add("asad");
		list.add("gf");
		list.add("jyh");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		/**
		 * JDK5.0新特性 foreash语句  
		 */
		
		for(String s : list){
			System.out.println(s);
		}
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10001, "qwe");
		map.put(10002, "iop");
		map.put(10003, "zxc");
		
		for(Integer key : map.keySet()){
			String val = map.get(key);
			System.out.println(key+".."+val);
		}
		
		for(Map.Entry<Integer, String> me : map.entrySet()){
			Integer key = me.getKey();
			String val = me.getValue();
			System.out.println(key+"...."+val);
		}
	}
	
	public static int add(int... arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
