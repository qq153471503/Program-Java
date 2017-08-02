import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * 【处理IO异常Demo】
 * @author KunGe
 *
 */
public class IOExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		demo_1();
	
		readFile();
	}
	
	private static void readFile() {
		FileReader fr = null;
		CharBuffer buf=null;

		try {
			int ch = 0;
			fr = new FileReader("G:\\123.txt");
			while((ch=fr.read()) != -1){
		
				System.out.println((char)ch);
			}
			
			System.out.println(buf);
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	private static void demo_1() {

		FileWriter fw = null;
		
		try {
			fw = new FileWriter("G:\\123.txt");
			fw.write("abcde");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw != null){
				
				try {
					fw.close();
				} catch (IOException e2) {
					throw new RuntimeException("文件关闭失败！");
				}
			}//end of if
		}
	}//end of fun
	
}

