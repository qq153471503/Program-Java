import java.io.FileWriter;
import java.io.IOException;


public class CharacterStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		demo_1();
	}

	private static void demo_1() throws IOException {
		
		//创建一个文件流对象
		FileWriter fw = new FileWriter("G:\\123.txt");
		

		fw.write("asdasjfals");
		fw.append('A');
		fw.close();
		
		FileWriter fw2 = new FileWriter("G:\\123.txt", true);
		fw2.write("XCVBNM,");
		fw2.close();
		
		
	}
}
