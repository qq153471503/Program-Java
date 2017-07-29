import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * 			【练习题】：请使用LinkedList模拟一个堆栈或者队列数据结构
 * 
 * 堆栈：栈->先进后厨 FILO
 * 
 * 队列：FIFO
 * 
 * 思路： 描述这样一个容器，给使用者对外提供方法
 * 
 *
 */

class MyQueue{
	private LinkedList link;
	MyQueue(){
		link = new LinkedList();
	}
	
	/**
	 * 队列添加元素的功能
	 * @param obj
	 */
	public void myAdd(Object obj) {
		link.add(obj);
	}
	
	public Object myGet() {
		return link.removeLast();
	}
	
	public boolean isNull() {
		return link.isEmpty();
	}
}


public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Collection coll = new ArrayList();
//		
//		show(coll);
		
		
//		Collection c1 = new ArrayList();
//		Collection c2 = new ArrayList();
//		show(c1, c2);
		LinkedList l = new LinkedList();
		show3(l);
	}
/*=========================================================================*/
	private static void show3(LinkedList list) {
		
		list.add("123");
		list.add("456");
		list.add("789");
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {

			System.out.println(iterator.next());
		}
		
		System.out.println();
		
		System.out.println("First : "+list.getFirst());
		System.out.println("End   : "+list.getLast());
		
		System.out.println(list.removeFirst());
		System.out.println(list);
		
		System.out.println(list.removeLast());
		System.out.println(list);
	}

	public static void show(Collection c1, Collection c2) {
		
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		c2.add("abc2");
		c2.add("abc6");
		c2.add("abc7");
		
		
		System.out.println(c1);
		System.out.println(c2);
		
		//addAll
		c1.addAll(c2);
		System.out.println(c1);
		
		//删除
		c1.removeAll(c2);
		System.out.println(c1);
		
		//包含
		c1.addAll(c2);
		System.out.println(c1.containsAll(c2));
	}
	public static void show(Collection coll) {
		
		//添加元素 add
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		
		System.out.println(coll);
		
		//删除元素
		coll.remove("abc2");
		System.out.println(coll);
		
		//清空
		coll.clear();
		System.out.println(coll);
		
		//包含
		System.out.println(coll.contains("abc4"));
		
	}
}




