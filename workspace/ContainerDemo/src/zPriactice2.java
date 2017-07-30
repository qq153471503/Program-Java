import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 	【练习题二】：字符串长度排序  注意是长度
 */
public class zPriactice2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		show1();
	}

	private static void show1() {
		TreeSet ts = new TreeSet(new ComparatorByLength());
		ts.add(new Person2(25,"ass"));
		ts.add(new Person2(32,"assdas"));
		ts.add(new Person2(17,"as"));
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}


class ComparatorByLength implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Person2 p1 = (Person2)o1;
		Person2 p2 = (Person2)o2;
		
		int tmp = p1.getName().length()-p2.getName().length();
		return tmp==0?p1.getAge()-p2.getAge():tmp;
	}
	
}







