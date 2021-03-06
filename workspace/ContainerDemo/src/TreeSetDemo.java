import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 		【TreeSet】：可以对集合中元素自然顺序排序  是不同步的
 * @author KunGe
 *
 */
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		show3();
	}
	private static void show3() {
		/**
		 * 存储对像 根据姓名比较 使用的是：TreeSet创建对象是传入比较方法
		 */
		
		TreeSet ts = new TreeSet(new ComparatorByName());
		
		ts.add(new Person2(23,"abc"));
		ts.add(new Person2(22,"def"));
		ts.add(new Person2(15,"xyz"));
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}	
	}
	/*
	 * 存储对象  根据年龄比较 使用的是Person2类中的toCompataor
	 */
	public static void show2() {
		TreeSet ts = new TreeSet();
		
		ts.add(new Person2(23,"abc"));
		ts.add(new Person2(22,"def"));
		ts.add(new Person2(15,"xyz"));
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}	
	}
	/**
	 * 存储字符串
	 */
	public static void show() {
		TreeSet ts = new TreeSet();
		
		ts.add("ab");
		ts.add("cd");
		ts.add("ef");
		ts.add("gh");
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}


/**
 * 创建一个根据Person2类中的name进行排序的比较器
 */

class ComparatorByName implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Person2 p1 = (Person2)o1;
		Person2 p2 = (Person2)o2;
		
		int tmp = p1.getName().compareTo(p2.getName());
		
		return tmp==0?p1.getAge()-p2.getAge():tmp;
	}
}

