import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author KunGe
 *
 *		��List������
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
		//���
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		
//		Iterator it = l.iterator();
//		Object obj = new Object();
//		while(it.hasNext()){
//			obj = it.next();				//ע��
//			if(obj.equals("abc3")){			//  ������ͬʱ��Ԫ�ؽ����޸� �ͻ�����java.util.ConcurrentModificationException�쳣
//				l.add("abc4");				//ע��
//			}
//			else {
//				System.out.println(it.next());
//			}
//		}// end of while 
		System.out.println(l);
		//�޷�ʹ�������ķ��� ���������б������
		ListIterator lit = l.listIterator();
		Object obj = new Object();
		while(lit.hasNext()){//�������      ���������lit.hasPrevious();
			
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
		//���
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		System.out.println(l);
		
		//ָ��λ�ò���
		l.add(1, 7);
		System.out.println(l);
		
		//ɾ��һ��
		l.remove(1);
		System.out.println(l);
		
		//�޸�Ԫ��
		l.set(0, 8);
		System.out.println(l);
	}

}



