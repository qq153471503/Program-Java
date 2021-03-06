import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 【 HashMap 】：存储自定义对象
 * 
 * @author KunGe
 *
 */
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<Student, String> hm = new HashMap<>();
		
		hm.put(new Student(12, "小强", 10001), "北京");
		hm.put(new Student(28, "小明", 10002), "上海");
		hm.put(new Student(72, "小志", 10032), "成都");
		hm.put(new Student(72, "小志", 10032), "济南");


//		Set<Student> setStu = hm.keySet();
//		Iterator<Student> it = setStu.iterator();
//		写成如下形式：
		Iterator<Student> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String city = hm.get(key);
			System.out.println(key.getAge()+key.getName()+"---"+city);
		}
	}

}



