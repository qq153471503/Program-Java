import java.util.ArrayList;
import java.util.Iterator;

/**
 * 		【存储自定义对象Demo】
 * 
 * @author KunGe
 *
 */
public class ArrayListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(new Person("123",10));
		al.add(new Person("456",11));
		al.add(new Person("789",12));
		al.add(new Person("000",13));
		
		Iterator it = al.iterator();
		
		//实际开发中  在一个循环中不使用这种方法 ，因为在一个循环中用两个.next，角标位置会多加1 下次循环角标就不准了
//		while(it.hasNext()){
//			System.out.println(((Person)it.next()).getName()+((Person) it.next()).getAge());
//		}
		
		//可以使用这种方式
		while(it.hasNext()){
			Person p = (Person)it.next();	//返回来的是Object  要强制向下转换
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}


class Person{
	
	private String name;
	private int age;
	
	Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	Person() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

