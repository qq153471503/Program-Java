import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;


public class ToolClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		demo_5();
	}

	/**
	 * 【集合转数组】
	 */
	private static void demo_5() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(19);
		al.add(654);
		al.add(82);
		
		Integer[] arr = al.toArray(new Integer[al.size()]);
		System.out.println(Arrays.toString(arr));
	}

	/**【重点】
	 * 【将数组转成List容器】
	 */
	private static void demo_4() {
		Integer[] arr = {1,3,5,7,9,2,4,6,8,10};
		List<Integer> list = Arrays.asList(arr);
		
		System.out.println(list);
		
		int[] arr2 = {38,665,79,12};
		List<int[]> list2 = Arrays.asList(arr2);
		System.out.println(list2);
	}

	/**
	 * 【将非同步容器 转成 同步的】
	 */
	private static void demo_3() {
		
		List<String> list = new ArrayList<>();
		list = Collections.synchronizedList(list);
	}

	/**
	 * 直接在创建容器对象的时候  传入Colletcions自带的逆序方法，实现逆转
	 */
	private static void demo_2() {
		TreeSet<String> li = new TreeSet<>(Collections.reverseOrder(new CompBylen()));
		li.add("fd");
		li.add("defg");
		li.add("abchj");
		li.add("xyzldr");
		li.add("xyz");
		System.out.println(li);
	}

	private static void demo_1() {
		List<String> li = new ArrayList<>();
		li.add("fd");
		li.add("defg");
		li.add("abchj");
		li.add("xyzldr");
		li.add("xyz");
		System.out.println(li);
		
		Collections.sort(li);		//排序
		System.out.println(li);
		
		Collections.swap(li, 1, 2); //交换位置
		System.out.println(li);
		
		Collections.sort(li, new CompBylen());		//根据自定义方式排序  这里以字符串长度
		System.out.println(li);

		Collections.sort(li);
		System.out.println(li);
		
		//折半查找
		int index = Collections.binarySearch(li, "a");
		System.out.println(index);
		
		index = Collections.binarySearch(li, "fd");
		System.out.println(index);

		
		//获取最大值
		String max = Collections.max(li);
		System.out.println(max);
		
		
		
	}

}

class CompBylen implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
 
}


/**
 * 【将不同步的容器转换成同步的】
 */












