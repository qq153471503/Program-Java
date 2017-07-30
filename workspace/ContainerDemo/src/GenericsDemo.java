import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * �����͡� demo
 * 
 */
public class GenericsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet<Person2> ts = new TreeSet<>(new ComparatorByLength());
		
		ts.add(new Person2(10, "asd"));
		ts.add(new Person2(28, "ro"));
		ts.add(new Person2(32, "poim"));
		
		Iterator<Person2> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getAge());
		}
		
	}

	
	public void show() {

		ArrayList<String> al = new ArrayList<>();
		
		al.add("abc");
		al.add("gsdif");
		al.add("yujo");
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}


