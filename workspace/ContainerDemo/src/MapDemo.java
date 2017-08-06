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
	 * �ڶ���ȥ����ʽ
	 */
	private static void method3(Map<Integer, String> map) {
		map.put(10001, "��ǿ");//����
		map.put(10002, "����");
		map.put(10003, "�ܻ�");//ɾ��Ԫ������
		
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
	 * ��һ��ȡ����ʽ
	 */
	public static void method2(Map<Integer, String> map) {
		map.put(10001, "��ǿ");//����
		map.put(10002, "����");
		map.put(10003, "�ܻ�");//ɾ��Ԫ������
		
		Set<Integer> lhs = map.keySet();
		Iterator<Integer> it = lhs.iterator();
		
		while(it.hasNext()){
			Integer key = it.next();
			String val = map.get(key);
			System.out.println(key+val);
		}
		
	}
	
	public static void method(Map<Integer, String> map) {
		
		map.put(10001, "��ǿ");//����
		map.put(10002, "����");
		map.put(10002, "�ܻ�");//ɾ��Ԫ������
		
		System.out.println(map);
	}
}




