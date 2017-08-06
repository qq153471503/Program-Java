import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Collection;

;

/*
 * ������ͨ���    ��  ��
 * 
 * �����޶�
 * 
 * �����ޡ���? extends E: 
 * 		ֻ�ܽ���E���ͻ������������� һ�����ڴ洢Ԫ�أ���Ϊ����ȡ�����ǰ�����������������ģ�������ְ�ȫ����
 * 
 * �����ޡ���? super E �� ֻ�ܽ���E���ͻ����丸������
 * 
 */
public class GenericesDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		show3();
	}


	/*
	 * ���޵����� TreeSet �ܹ�����
	 */
	private static void show3() {
		TreeSet<Student> al = new TreeSet<>();
		al.add(new Student(12, "xiaoming", 10001));
		al.add(new Student(15, "liqiang", 10002));
		
		TreeSet<Animal> al2 = new TreeSet<>();
		al2.add(new Animal("dog", 32));
		al2.add(new Animal("cat", 17));
		
		TreeSet<Person2> al3 = new TreeSet<>();
		al3.add(new Person2(18, "wangchao"));
		al3.add(new Person2(22, "zhangrui"));
		
		
		TreeSet<Person2> al4 = new TreeSet<>();
		al4.addAll(al3);
		al4.addAll(al);
		
		Iterator<Person2> it = al4.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		/*
		 * ��ע�⡿���Ƚ���ʹ�������ޣ� �Դ������մ���Ķ�����㷺�����ҿ��Զ����ո���Ĺ�������
		 */
		TreeSet<Student> ts = new TreeSet<Student>(new CompareByName2());
		ts.addAll(al);
	}


	/*
	 * ���޵�����
	 */
	private static void show2() {
		ArrayList<Student> al = new ArrayList<>();
		al.add(new Student(12, "xiaoming", 10001));
		al.add(new Student(15, "liqiang", 10002));
		
		ArrayList<Animal> al2 = new ArrayList<>();
		al2.add(new Animal("dog", 32));
		al2.add(new Animal("cat", 17));
		
		ArrayList<Person2> al3 = new ArrayList<>();
		al3.add(new Person2(18, "wangchao"));
		al3.add(new Person2(22, "zhangrui"));
		
		
		ArrayList<Person2> al4 = new ArrayList<>();
		al4.addAll(al3);
		al4.addAll(al);
		System.out.println(al4);

	}


	public static void show() {
		TreeSet<Student> al = new TreeSet<>();
		al.add(new Student(12, "xiaoming", 10001));
		al.add(new Student(15, "liqiang", 10002));
		
		printColl(al);		//�������  ArrayListָ��������Ϊstudent ��Persion2������
		
//		ArrayList<Animal> al2 = new ArrayList<>();
//		al2.add(new Animal("dog", 32));
//		al2.add(new Animal("cat", 17));
//		printColl(al2);		//�������  al2ָ�������Ͳ���Persion2������
	}

	
	//�޶�  ֻ��Persion2�����ഫ����
	public static void printColl(Collection<? extends Person2> coll) {
		Iterator<? extends Person2> it = coll.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}


class Student extends Person2{

	private int id;
	Student(int age, String name, int id) {
		super(age, name);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}


class CompareByName2 implements Comparator<Person2>{

	@Override
	public int compare(Person2 o1, Person2 o2) {
		
		int tmp = o1.getAge()-o2.getAge();
		return tmp==0?o1.getName().compareTo(o2.getName()):tmp;
	}
	
}


