package Properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Set;

/*
 * Map
 * 	|-HashTable
 * 	  |-Properies
 */

/**
 * 【Properies】：演示Demo
 * 
 * @author KunGe
 *
 *		1、集合中的key和value都是字符串类型
 *		2、集合中的数据可以保存到流中，或者从流获取
 *		
 *		通常该集合用于操作以键值对形式存在的配置文件   配置文件：配置应用程序的属性，例如EditPlus的配置文件，可以更改Tab的空格大小
 *		还有xml文件
 *		还有数据库
 */
public class ProperiesDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//基本存取
//		demo_1();
		
		//与流对象相结合
		demo_2();
		
	}

	/*
	 * 【模拟load方法】
	 */
	private static void load(){
		
	}
	private static void demo_2() throws IOException {
		Properties pro = new Properties();

		
		File file = new File("G:\\info.txt");
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("G:\\info.txt")));
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\info.txt"),"GBK"));
//		pro.store(fop, "这是描述文件测试!");
//		fop.close();
		
//		pro.load(new FileInputStream("G:\\info.txt"));
		
		pro.load(bufr);
		pro.list(System.out);
		
	
		pro.setProperty("c", "5");
		
		
		pro.store(bufw, "");
		
		
	}

	private static void demo_1() {
		Properties pro = new Properties();
		
		//存储
		pro.setProperty("l", "abc");
		pro.setProperty("2", "def");
		pro.setProperty("3", "ghi");
		pro.setProperty("4", "jkl");
		
		//修改
		pro.setProperty("3刘安坤", "1321321321");
		
		//取出
		Set<String> names = pro.stringPropertyNames();
		
		for(String str : names){
			System.out.println(str+pro.getProperty(str));
		}
	}

}
