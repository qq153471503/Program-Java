package FileObject;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 【File类】：使用演示Demo
 * @author KunGe
 *
 */
public class FileDemo1 {

	private static final String DIR = "G:\\";

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

//		demo_1();
//		
//		//创建
//		demo_2();
//		
		//判断
//		demo_3();
		
		//获取容量
//		demo_4();
		
		/**
		 * 【练习】：获取最大自由使用空间的盘符
		 * 
		 * 【思路】：
		 * 			1、可用空间和盘符存在着关系，所以选用Map这个容器，
		 * 			2、先获得系统盘符列表，利用File类中的getFreeSpace()方法获得可用空间当作键，利用File类中的toString方法获得盘符当作值
		 * 			3、定义一个临时变量，记录最大值，这个最大值就是 具有最大可用空间盘符的标识
		 * 			4、利用键  获得 值， 值即为盘符
		 * 
		 * 【方法1】：利用变量方法记录  麻烦
		 * 【方法二】：在创建TreeMap集合时，传入比较器，由大到小排序，利用TreeMap的firstKey,获得第一个key，利用key获得值
		 */
//		priactice2();
		
		
		/*
		 * 【获得目录下的内容】
		 */
//		dema_5();
		
		/**
		 * 【根据过滤器获得目录下的内容】  获得该目录下所有的.txt文件  字符串方式
		 */
//		demo_6();
		
		/**
		 * 【根据过滤器获得目录下的内容】  获得该目录下所有的.txt文件  对象方式
		 */
		
		demo_7();
		
	}

	private static void demo_7() {
		File fi = new File(DIR);
		File[] fis = fi.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return dir.isDirectory();
				
			}
		});

		for(File files : fis){
			System.out.println(files);
		}
	}

	private static void demo_6() {
		File fi = new File(DIR);
		String[] list = fi.list();
		
		for(String str : list){
			System.out.println(str);
		}
		
		String[] list2 = fi.list(new FilterBySuffix(".txt"));
		
		System.out.println();
		System.out.println("所有.txt文件如下：");
		
		
		for(String str : list2){
			System.out.println(str);
		}
		
		
	}
	

	private static void dema_5() {
		File fi = new File(DIR);
		String[] list = fi.list();
		
		for(String str : list){
			System.out.println(str);
		}
	}

	private static void priactice2() {
		TreeMap<Long, String> tm = new TreeMap<>(new CompByChar());
		File[] files = File.listRoots();
		
		for(File file : files){
			tm.put(file.getFreeSpace(), file.toString());
		}
		
		System.out.println(tm.get(tm.firstKey()));

		System.out.println();;System.out.println();

		Set<Long> set = tm.keySet();
		Iterator<Long> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	private static void priactice() {

		TreeMap<Long, String> tm = new TreeMap<>();
		File[] file = File.listRoots();
		
		for(File fi : file){
			tm.put(fi.getFreeSpace(), fi.toString());
		}
		
		Set<Entry<Long, String>> map2set = tm.entrySet();
		Iterator<Entry<Long, String>> it = map2set.iterator();
		
		long max=0;
		while(it.hasNext()){
			Map.Entry<Long, String> map = it.next();
			long key = map.getKey();
			max = max>key?max:key;
		}
		
		System.out.println(tm.get(max)+ " --> " +max);
		
	}

	private static void demo_4() {
		
		File[] files = File.listRoots();
		
		for(File file : files){
			System.out.println(file);
		}
		
		File f2 = new File("C:\\");
		System.out.println(f2.getFreeSpace());	//自由空间
		System.out.println(f2.getTotalSpace());	//容量
		System.out.println(f2.getUsableSpace());//可用空间
		
	}

	private static void demo_3() {

		File file = new File("123.txt");
		System.out.println(file.exists());	//文件是否存在
		
		File file2 = new File("G:\\465.TXT");
		
		System.out.println(file.renameTo(file2));

	}

	private static void demo_2() throws Exception {
		File file = new File("test.txt");
		System.out.println(file.createNewFile());
		
		System.out.println(file.delete());
		
		File fi = new File("123test");
		System.out.println(fi.mkdir());
		System.out.println(fi.delete());
	}

	private static void demo_1() throws IOException {
		File fi = new File("123.txt");

		System.out.println("path			:"+fi.getAbsolutePath());
		System.out.println("FreeSpace		:"+fi.getFreeSpace());
		
		long lastTime = fi.lastModified();
		Date d = new Date(lastTime);
		DateFormat df = DateFormat.getDateTimeInstance();
		String time = df.format(d);
		System.out.println("lastModified		:"+time);
		
		System.out.println(fi.getParentFile());
	}

}

class CompByChar implements Comparator<Long>{

	@Override
	public int compare(Long o1, Long o2) {
		int tmp = (int) (Long.valueOf(o2)-(Long.valueOf(o1)));
		if(tmp>0)
			return 1;
		if(tmp<0)
			return -1;
		return 0;
	}

}


/*  过滤器   过滤后缀  */
class FilterBySuffix implements FilenameFilter{

	String suffix;

	public FilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
		
	}
	
}

