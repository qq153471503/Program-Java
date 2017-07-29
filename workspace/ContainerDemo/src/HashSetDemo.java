import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @author KunGe
 *
 *		����HashSet�����д洢�Զ�����󡿣��洢Persion����  ������� ����һ�� ��Ϊͬһ����
 */
public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet hs = new HashSet<>();
		hs.add(new Person2(10, "��ǿ"));
		hs.add(new Person2(20, "����"));
//		hs.add(new Person2(30, "����"));
//		hs.add(new Person2(30, "����"));
		
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


class Person2{
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
		System.out.println(this.toString()+"  .....hashCode...");
		return this.name.hashCode()+this.age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(! (obj instanceof Person2))
			throw new ClassCastException("��������ʹ���");
		
		System.out.println(this.toString()+"  .....equals...");
		Person2 p = (Person2)obj;
		if( (this.name == p.getName()) && (this.age == p.getAge()))
			return true;
		else 
			return false;
	}
	@Override
	public String toString() {
		
		return this.name+":"+this.age;
	}
	
}


