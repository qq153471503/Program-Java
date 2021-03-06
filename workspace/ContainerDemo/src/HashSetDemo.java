import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @author KunGe
 *
 *		【往HashSet集合中存储自定义对象】：存储Persion对象  如果年龄 姓名一致 视为同一个人
 */
public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet hs = new HashSet<>();
		hs.add(new Person2(10, "王强"));
		hs.add(new Person2(20, "李明"));
//		hs.add(new Person2(30, "赵磊"));
//		hs.add(new Person2(30, "赵磊"));
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			Person2 p2 = (Person2)it.next();
			System.out.println(p2.getAge()+"..."+p2.getName());
		}
		
		System.out.println();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		
	}
}


class Person2 implements Comparable<Person2>{
	private int age;
	private String name;
	Person2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
//		System.out.println(this.toString()+"  .....hashCode...");
		return this.name.hashCode()+this.age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(! (obj instanceof Person2))
			throw new ClassCastException("传入的类型错误！");
		
//		System.out.println(this.toString()+"  .....equals...");
		Person2 p = (Person2)obj;
		if( (this.name == p.getName()) && (this.age == p.getAge()))
			return true;
		else 
			return false;
	}
	@Override
	public String toString() {
		
		return "Person2 :"+this.name+":"+this.age;
	}
	@Override
	public int compareTo(Person2 o) {

//		Person2 p = (Person2)o;
		if(!(o instanceof Person2))
			throw new ClassCastException("传入类型错误！");
		
		int tmp = this.age - o.age;
		
		return tmp==0?this.name.compareTo(o.name):tmp;
	}
	
	
}




