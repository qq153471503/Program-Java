
public class ObjectClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person(20);
		Person p2 = new Person(20);
		
		System.out.println(p1.equals(p2));
		
		Person p3 = new Person(10);
		Demo d = new Demo();
//		System.out.println(p3.equals(d));
		
		Demo d2 = new Demo();
		Demo d3 = new Demo();
		Class c1 = d2.getClass();
		Class c2 = d3.getClass();
		
		System.out.println(c1==c2);
		System.out.println(c1.getName());
		System.out.println(c1);
		System.out.println(c1.getName()+"@"+Integer.toHexString(c1.hashCode()));
		System.out.println("-------------------------------------------------");
		
		
		Demo d4 = new Demo();
		System.out.println(d4.getName());
		
	}

}

class Demo{
	
	private int age;
	public String getName() {
		
		return "Demo :"+this.age;
	}
}

class Person extends Object{
	
	private int age;
	Person(int age){
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
		this.getClass();
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Person)){
		
			throw new ClassCastException("����ת���쳣");
//			return false;
		}
		Person p = (Person)obj;
		return this.age == p.age;
	}
}




