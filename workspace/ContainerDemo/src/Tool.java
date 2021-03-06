

class Animal<T> implements Comparable<T>{
	private String name;
	private int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	Animal(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	@Override
	public int compareTo(T o) {
		
		
		return 0;
	}
	
}

/**
 * 【泛型类】
 * @author KunGe
 *
 * @param <C1>
 * @param <C2>
 */
public class Tool<C1,C2> {

	private C1 c1;
	private C2 c2;
	
	
	public C1 getC1() {
		return c1;
	}


	public void setC1(C1 c1) {
		this.c1 = c1;
	}


	public C2 getC2() {
		return c2;
	}


	public void setC2(C2 c2) {
		this.c2 = c2;
	}


	Tool() {
		super();
	}
	
	
	public <M> void show(M str) {
		System.out.println(str);
	}
	
}


/**
 * 【泛型接口】
 * */

interface Inter<T>{
	abstract public void show(T t);
}

//1
class InterImpl implements Inter<String>{

	@Override
	public void show(String t) {
		System.err.println(t);
	}
	
}

//2
class InterImpl2<Q> implements Inter<Q>{

	@Override
	public void show(Q t) {
		System.out.println(t);
	}
	
}












