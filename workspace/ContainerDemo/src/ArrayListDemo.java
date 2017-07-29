import java.util.ArrayList;
import java.util.Iterator;

/**
 * 		���洢�Զ������Demo��
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
		
		//ʵ�ʿ�����  ��һ��ѭ���в�ʹ�����ַ��� ����Ϊ��һ��ѭ����������.next���Ǳ�λ�û���1 �´�ѭ���Ǳ�Ͳ�׼��
//		while(it.hasNext()){
//			System.out.println(((Person)it.next()).getName()+((Person) it.next()).getAge());
//		}
		
		//����ʹ�����ַ�ʽ
		while(it.hasNext()){
			Person p = (Person)it.next();	//����������Object  Ҫǿ������ת��
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
