import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Collection;

;

/*
 * 【泛型通配符    ？  】
 * 
 * 泛型限定
 * 
 * 【上限】：? extends E: 
 * 		只能接收E类型或者其子类类型 一般用在存储元素，因为这样取出都是按照上限类型来运算的，不会出现安全隐患
 * 
 * 【下限】：? super E ： 只能接收E类型或者其父类类型
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
	 * 下限的体现 TreeSet 能够体现
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
		 * 【注意】：比较器使用了上限， 以此来接收传入的对象更广泛，并且可以都按照父类的规则排序
		 */
		TreeSet<Student> ts = new TreeSet<Student>(new CompareByName2());
		ts.addAll(al);
	}


	/*
	 * 上限的体现
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
		
		printColl(al);		//可以输出  ArrayList指定了类型为student 是Persion2的子类
		
//		ArrayList<Animal> al2 = new ArrayList<>();
//		al2.add(new Animal("dog", 32));
//		al2.add(new Animal("cat", 17));
//		printColl(al2);		//编译出错  al2指定的类型不是Persion2的子类
	}

	
	//限定  只能Persion2的子类传进入
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



