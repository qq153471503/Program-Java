import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * �� HashMap �����洢�Զ������
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
		
		hm.put(new Student(12, "Сǿ", 10001), "����");
		hm.put(new Student(28, "С��", 10002), "�Ϻ�");
		hm.put(new Student(72, "С־", 10032), "�ɶ�");
		hm.put(new Student(72, "С־", 10032), "����");


//		Set<Student> setStu = hm.keySet();
//		Iterator<Student> it = setStu.iterator();
//		д��������ʽ��
		Iterator<Student> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String city = hm.get(key);
			System.out.println(key.getAge()+key.getName()+"---"+city);
		}
	}

}


