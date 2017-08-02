import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/*
 * 【字节流】：可以操作字符，也可以处理媒体文件
 * 
 * 
 * 注意：  无需临时存储缓冲，直接写入
 */
public class ByteStreanDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/* 写 */
		demo_1();
		
		/* 读  */
//		demo_2();
		
		/* demo_2 的简化形式 */
		demo_3();
		
	}

	private static void demo_3() throws IOException {
		FileInputStream fip = new FileInputStream("G:\\123.txt");
		
		//小文件可以用 大文件不适用
		byte[] buf = new byte[fip.available()];		//获得文件有多少字节
		
		fip.read(buf);
		System.out.println(new String(buf));
		
		
		
		//【建议使用自己定义数组的方式】
	}

	private static void demo_2() throws IOException {
		FileInputStream fip = new FileInputStream("G:\\123.txt");
		int ch = 0;
		while((ch=fip.read()) != -1){
			System.out.println((char)ch);
		}
	}

	private static void demo_1() throws IOException {
		
		//1、创建字节流=输出流对象 操作文件  
		FileOutputStream fop = new FileOutputStream("G:\\123.txt");
		fop.write("abc".getBytes());
		fop.close();
	}

}
