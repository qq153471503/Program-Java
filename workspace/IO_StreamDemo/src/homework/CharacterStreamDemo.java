package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 【练习题】：复制文件到另一个位置
 * 
 * @author KunGe
 *
 */
public class CharacterStreamDemo {

	private static final int BUF_SIZE = 1024*4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//利用字符
//		copy("G:\\123.txt", "F:\\123.txt");
		
		//利用数组缓冲
//		copy2("G:\\123.txt", "F:\\123.txt");
		
		//利用缓冲区
		copy3("G:\\123.txt", "F:\\123.txt");
	}
	
	private static void copy3(String sourceDir, String objDir) {
		FileReader fr=null;
		FileWriter fw=null;
		BufferedWriter bufWrite = null;
		BufferedReader bufRead = null;
		LineNumberReader lnr = null;
		
		try {
			fr = new FileReader(sourceDir);
			 bufRead = new BufferedReader(fr);
			 lnr = new LineNumberReader(bufRead);
			try {
				fw = new FileWriter(objDir);
				bufWrite = new BufferedWriter(fw);
			} catch (IOException e1) {
				
				throw new RuntimeException("复制文件过程中出错！");
			}
			
			try {
				String flag = "";
//				while((flag=bufRead.readLine()) != null){
//					bufWrite.write(flag);
//					bufWrite.newLine();
//					bufWrite.flush();
//					System.out.println(flag);
//				}
				
				while((flag=lnr.readLine()) != null){
					bufWrite.write(flag);
					System.out.println(lnr.getLineNumber()+":"+flag);
				}
				
			} catch (IOException e) {
				
				throw new RuntimeException("复制文件过程中出错！");
			}

			
		} catch (FileNotFoundException e) {
			
			throw new RuntimeException("要复制的文件未找到！");
		} finally {
				try {
					bufRead.close();
				} catch (IOException e) {
					
					throw new RuntimeException("关闭文件失败！");
				}
				
				try {
					bufWrite.close();
				} catch (IOException e) {
					
					throw new RuntimeException("关闭文件失败！");
				}
		}
		
		
	}

	private static void copy2(String sourceDir, String objDir) {
		
		FileReader fr=null;
		FileWriter fw=null;
		try {

			int len = 0;
			char[] buf = new char[BUF_SIZE];
			fr = new FileReader(sourceDir);
			fw = new FileWriter(objDir);
			
			while((len=fr.read(buf)) != -1){
				fw.write(buf, 0, len);
			}
			
			
		} catch (Exception e) {

			throw new RuntimeException("文件复制出错！");
			
		}finally {

			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					
					throw new RuntimeException("写文件关闭失败！");
				}
			
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					
					throw new RuntimeException("读文件关闭失败!");
				}
		}	
	}

	public static void copy(String sourceDir, String objDir) {
		
		FileReader fr=null;
		FileWriter fw=null;
		try {

			int tmp=0;
			fr = new FileReader(sourceDir);
			fw = new FileWriter(objDir);
			
			while((tmp=fr.read()) != -1){
				fw.write(tmp);
			}
			
		} catch (Exception e) {

			throw new RuntimeException("文件复制出错！");
			
		}finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e) {

				throw new RuntimeException("关闭文件失败！");
			}
		}
	}
}




