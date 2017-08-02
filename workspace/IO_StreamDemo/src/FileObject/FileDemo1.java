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
 * ��File�ࡿ��ʹ����ʾDemo
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
//		//����
//		demo_2();
//		
		//�ж�
//		demo_3();
		
		//��ȡ����
//		demo_4();
		
		/**
		 * ����ϰ������ȡ�������ʹ�ÿռ���̷�
		 * 
		 * ��˼·����
		 * 			1�����ÿռ���̷������Ź�ϵ������ѡ��Map���������
		 * 			2���Ȼ��ϵͳ�̷��б�����File���е�getFreeSpace()������ÿ��ÿռ䵱����������File���е�toString��������̷�����ֵ
		 * 			3������һ����ʱ��������¼���ֵ��������ֵ���� ���������ÿռ��̷��ı�ʶ
		 * 			4�����ü�  ��� ֵ�� ֵ��Ϊ�̷�
		 * 
		 * ������1�������ñ���������¼  �鷳
		 * �������������ڴ���TreeMap����ʱ������Ƚ������ɴ�С��������TreeMap��firstKey,��õ�һ��key������key���ֵ
		 */
//		priactice2();
		
		
		/*
		 * �����Ŀ¼�µ����ݡ�
		 */
//		dema_5();
		
		/**
		 * �����ݹ��������Ŀ¼�µ����ݡ�  ��ø�Ŀ¼�����е�.txt�ļ�  �ַ�����ʽ
		 */
//		demo_6();
		
		/**
		 * �����ݹ��������Ŀ¼�µ����ݡ�  ��ø�Ŀ¼�����е�.txt�ļ�  ����ʽ
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
		System.out.println("����.txt�ļ����£�");
		
		
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
		System.out.println(f2.getFreeSpace());	//���ɿռ�
		System.out.println(f2.getTotalSpace());	//����
		System.out.println(f2.getUsableSpace());//���ÿռ�
		
	}

	private static void demo_3() {

		File file = new File("123.txt");
		System.out.println(file.exists());	//�ļ��Ƿ����
		
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


/*  ������   ���˺�׺  */
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

