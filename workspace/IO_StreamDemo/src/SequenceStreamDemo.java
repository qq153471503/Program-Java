import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 【序列流】：演示demo
 * 
 * 序列流：表示其他输入流的串联
 * @author KunGe
 *
 */
public class SequenceStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		vectorDemo();
		arrayListDemo();
		
	}

	/**
	 * 【ArrayList】：不支持枚举  需要自己new枚举  使用迭代
	 * @throws IOException
	 */
	private static void arrayListDemo() throws IOException {
		ArrayList<FileInputStream> al = new ArrayList<>();
		
		for (int i = 1; i < 4; i++) {
			al.add(new FileInputStream("g:\\"+i+".txt"));
		}
		
//		final Iterator<FileInputStream> it = al.iterator();
		//使用工具类 里面的这个方法，就是如下自己实现的的封装
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		
		//自己实现 
		/*Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
			
			@Override
			public FileInputStream nextElement() {
				
				return it.next();
			}
			
			@Override
			public boolean hasMoreElements() {
				
				return it.hasNext();
			}
		};*/
		
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fop = new FileOutputStream("G:\\4.txt");
		
		int flag = 0;
		
		while ((flag=sis.read()) != -1) {
			fop.write(flag);
		}
		
		fop.close();
		sis.close();
	}

	/**
	 * 【vector容器支持枚举，此方法使用枚举形式】
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void vectorDemo() throws FileNotFoundException, IOException {
		Vector<FileInputStream> vec = new Vector<>();
		
		vec.add(new FileInputStream("G:\\1.TXT"));
		vec.add(new FileInputStream("G:\\2.TXT"));
		vec.add(new FileInputStream("G:\\2.TXT"));
		
		Enumeration<FileInputStream> en = vec.elements();
		
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fop = new FileOutputStream("G:\\4.txt");
		
		int flag = 0;
		
		while ((flag=sis.read()) != -1) {
			fop.write(flag);
		}
		
		fop.close();
		sis.close();
	}

}

