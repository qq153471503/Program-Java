import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 	����ϰ�⡿��ȥ��ArrayList�е��ظ�Ԫ��
 * 
 * 
 * @author KunGe
 *
 */
public class zPriactice1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		singleDemo();
		singleDemo2();
		
	}

	private static void singleDemo2() {
		ArrayList al = new ArrayList<>();
		al.add(new Person2(10, "��ǿ"));
		al.add(new Person2(20, "����"));
		al.add(new Person2(30, "����"));
		al.add(new Person2(30, "����"));
		
		System.out.println(al);
		al = getStingElement(al);
		System.out.println(al);
		
		System.out.println();
		
		System.out.println(al.remove(new Person2(20,"����")));
		System.out.println(al);
	}

	public static void singleDemo() {
		ArrayList al = new ArrayList<>();
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");
		al.add("abc4");
		
		System.out.println(al);
		al = getStingElement(al);
		System.out.println(al);
	}

	private static ArrayList getStingElement(ArrayList al) {
		
		ArrayList tmp = new ArrayList();
		Iterator it = al.iterator();
		
		while(it.hasNext()){
			Object obj = it.next();
			if (!tmp.contains(obj)) {
				tmp.add(obj);
			}
		}
		return tmp;
	}

}

