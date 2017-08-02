import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 【自定义输出编码格式 进行输出】
 * @author KunGe
 *
 */
public class Demo2 {

	private static final String TXT_DIR = "G:\\123.txt";

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		writeText();
		writeRead();
	}

	private static void writeRead() throws IOException, FileNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(TXT_DIR)));
		String tmp = null;
		
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		
		while((tmp=br.readLine()) != null){
			bw.write(tmp);
			bw.flush();
		}
	}

	private static void writeText() throws IOException {
		OutputStreamWriter outs = new OutputStreamWriter(new FileOutputStream(TXT_DIR));
	
		outs.write("你好");
		outs.close();
	}

}
