import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author KunGe
 *
 *		【List】容器
 *
 */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List list = new ArrayList();
		
//		show(list);
		show2(list);
	}

	private static void show2(List l) {
		//添加
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		
//		Iterator it = l.iterator();
//		Object obj = new Object();
//		while(it.hasNext()){
//			obj = it.next();				//注意
//			if(obj.equals("abc3")){			//  迭代器同时对元素进行修改 就会引发java.util.ConcurrentModificationException异常
//				l.add("abc4");				//注意
//			}
//			else {
//				System.out.println(it.next());
//			}
//		}// end of while 
		System.out.println(l);
		//无法使用容器的方法 但可以用列表迭代器
		ListIterator lit = l.listIterator();
		Object obj = new Object();
		while(lit.hasNext()){//正向遍历      逆向遍历：lit.hasPrevious();
			
			obj = lit.next();
			if(obj.equals("abc2")){
				lit.add("abc4");
			}
			
			if(obj.equals("abc1"))
				lit.set("abc5");
			
		}// end of while
		
		System.out.println(l);
	}

	private static void show(List l) {
		//添加
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		System.out.println(l);
		
		//指定位置插入
		l.add(1, 7);
		System.out.println(l);
		
		//删除一个
		l.remove(1);
		System.out.println(l);
		
		//修改元素
		l.set(0, 8);
		System.out.println(l);
	}

}



