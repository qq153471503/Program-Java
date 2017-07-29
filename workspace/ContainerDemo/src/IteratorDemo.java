import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class IteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Collection coll = new ArrayList();
		
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		
		Iterator it =  coll.iterator();
		
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.hasNext());
		
		container(coll);
		
		//开发中使用该种方式  省内存
		for (Iterator ite = coll.iterator(); ite.hasNext();) {
			System.out.println(ite.next());
		}
	}
	
	private static void container(Collection c) {
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}


