import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.xml.crypto.Data;


public class API_SystemDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static Data d;
	/**
	 * @param args
	 */
	public static void main(String[] args) {


/*  时间获得示例  */
//		demo1();
		
/* time to String demo  */
		demo2();
	}

	private static void demo2() throws ParseException {
		
		String str_data = "2017-08-01";
		DateFormat df = DateFormat.getDateInstance();
		 date = df.parse(str_data);
		System.out.println(date);
	}

	private static void demo1() {
		Date d = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(df.format(d));
	
		df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		System.out.println(df.format(d));
		
		//自定义格式
		df = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(df.format(d));
	}

	private static void showPro() {
		Properties pro = System.getProperties();
//		Iterator<Object> it = pro.keySet().iterator();
//		while(it.hasNext()){
//			System.out.print(it.next());
//			System.out.println("-->>"+pro.get(it.next()));
//			System.out.println();
//		}
		
		//第二种方法
		Set<String> nameSet = pro.stringPropertyNames(); //获得键
		for(String s : nameSet){
			String val = pro.getProperty(s);				//根据键获得值
			System.out.println(s+"..."+val);
		}
		
//		System.out.println("hello"+LINE_SEPARATOR+"world");
//		showPro();
//		System.setProperty("z--->username", "刘安坤");
//		showPro();
		
		Runtime rt = Runtime.getRuntime();
//		try {
//			rt.exec("notepad.exe");
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		} 
		
//		try {
//			Process p = rt.exec("notepad.exe");
//			p.destroy();
//		} catch (IOException e) {
//			
//		}
	}
}



