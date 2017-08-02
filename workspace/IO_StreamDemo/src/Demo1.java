import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 【键盘录入】：打印在控制台
 * @author KunGe
 *
 */
public class Demo1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		readKey3();
	}

	/**
	 * 【方式二】：转换流 直接读取一行 
	 * @throws IOException 
	 */
	private static void readKey3() throws IOException {
		//读取控制台
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//读取文件
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\123.txt")));
		
		//输出到控制台
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//输出到文件
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("G:\\1234.txt")));
		
		String tmp="";
//		System.out.print("请输入【以over结束】：");
		
		while((tmp=in.readLine()) != null){
			if(tmp.equals("over"))
				break;
//			System.out.println("你输入的是："+tmp);
//			System.out.print("请输入【以over结束】："；);
//			out.write("请输入【以over结束】：");
//			out.write("你输入的是："+tmp);
			out.write(tmp);
			out.newLine();
			out.flush();
		}
	}

	/*
	 * 【方式1】：读取一个byte 将byte存到StringBUffer中  然后打印到控制台
	 */
	private static void readKey2() throws IOException {
		
		StringBuffer sb = new StringBuffer();
		InputStream in = System.in;
		int ch = 0;
		
		System.out.print("请输入【以over结束】：");
		while((ch=in.read()) != -1){
			
			if(ch == '\r')
				continue;
			if(ch == '\n'){
				String tmp = sb.toString();
				if("over".equals(tmp)){
					break;
				}
				
				System.out.println("你输入的内容是："+tmp);
				System.out.print("请输入【以over结束】：");
				sb.delete(0, sb.length());
			}else {
				sb.append((char)ch);
			}
		}
	}

	private static void readKey() throws IOException {
		InputStream in = System.in;
		int ch = in.read();
		System.out.println((char)ch);
		in.close();
	}

}


