import java.util.ArrayList;
import java.util.Collection;


public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Collection coll = new ArrayList();
//		
//		show(coll);
		
		
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		show(c1, c2);
	}

	public static void show(Collection c1, Collection c2) {
		
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		c2.add("abc2");
		c2.add("abc6");
		c2.add("abc7");
		
		
		System.out.println(c1);
		System.out.println(c2);
		
		//addAll
		c1.addAll(c2);
		System.out.println(c1);
		
		//ɾ��
		c1.removeAll(c2);
		System.out.println(c1);
		
		//����
		c1.addAll(c2);
		System.out.println(c1.containsAll(c2));
	}
	public static void show(Collection coll) {
		
		//����Ԫ�� add
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		
		System.out.println(coll);
		
		//ɾ��Ԫ��
		coll.remove("abc2");
		System.out.println(coll);
		
		//���
		coll.clear();
		System.out.println(coll);
		
		//����
		System.out.println(coll.contains("abc4"));
		
	}
}