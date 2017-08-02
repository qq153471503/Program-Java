package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 【练习题】：复制MP3格式文件
 * @author KunGe
 *
 */
public class ByteStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		copy_2();
	}

	private static void copy_2() throws IOException {
		FileInputStream fip = new FileInputStream("G:\\if-you-feel-my-love.mp3");
		BufferedInputStream bip = new BufferedInputStream(fip);
		FileOutputStream fop = new FileOutputStream("G:\\if-you-feel-my-love2.mp3");
		BufferedOutputStream bop = new BufferedOutputStream(fop);
		
		int len = 0;
		byte[] buf = new  byte[1024];
		
		while((len=bip.read(buf)) != -1){
			bop.write(buf,0,len);
			bop.flush();
		}
		
		bop.close();
		bip.close();
	}

	private static void copy_1() throws IOException {
		FileInputStream fip = new FileInputStream("G:\\if-you-feel-my-love.mp3");
		
		FileOutputStream fop = new FileOutputStream("G:\\if-you-feel-my-love2.mp3");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fip.read(buf))!=-1){
			fop.write(buf, 0, len);
		}
		
		fop.close();
		fip.close();
	}

}
