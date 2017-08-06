import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class TreeMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeMap<Student, String> tm = new TreeMap<>(new CompByAge());
		tm.put(new Student(20, "xiaowanh", 10001), "�Ϻ�");
		tm.put(new Student(18, "wangzhi", 10002), "����");
		tm.put(new Student(23, "tianjing", 10003), "���");
		tm.put(new Student(24, "tianjing", 10003), "���");
		
		
		//��һ�ַ�ʽ  it�õ����Ǽ�
//		Iterator<Student> it = tm.keySet().iterator();
//		while(it.hasNext()){
//			Student key = it.next();
//			String city = tm.get(key);
//			System.out.println(city+"...."+key.getAge()+key.getId()+key.getName());
//		}
		
		//�ڶ��ַ�ʽ  it�õ����Ǽ���ֻ�Ĺ�ϵ
		Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Student, String> me = it.next();
			String city = me.getValue();
			Student key = me.getKey();
			System.out.println(key.getAge()+"..."+key.getName()+city);
		}
		
	}

}



class CompByAge implements Comparator<Person2>{

	@Override
	public int compare(Person2 o1, Person2 o2) {
		
		int tmp = o1.getAge()-o2.getAge();
		return tmp==0?o1.getName().compareTo(o2.getName()):tmp;
	}
}







