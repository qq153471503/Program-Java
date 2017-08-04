package Practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *【综合练习】：读取一个目录中 指定类型的文件 的路径，将路径存储进一个文件中。 
 * @author KunGe
 *
 *
 *【思路】：
 *	整体思路：1、深度遍历文件路径，查找文件
 *					创建文件对象，列出该目录下的文件，判断是否为文件夹，如是，继续往下遍历，若不是，
 *					判断是否是指定类型文件，若是，写入到记录文件中，若不是，舍弃
 *			2、写入到文件
 */
public class PracticeDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		
		
		try {
			File obj = fun("H:\\Program-Java\\workspace", new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					
					return dir.toString().endsWith(".java");
				}
			}, "G:\\info.txt");
		} catch (IOException e) {
			
			throw new RuntimeException("获取文件出错！");
		}
		
	}

	/**
	 * 【按照给定的位置深度查找指定类型的文件，并输出到指定文件中】
	 * @param findLocation	要查找的位置
	 * @param fileType	文件类型
	 * @param saveLocation 要输出的文件本地的保存位置及类型
	 * @return	saveLocation文件的引用
	 * @throws Exception
	 * @throws IOException
	 */
//	private static File fun(String findLocation, String fileType, String saveLocation) throws IOException {
//		File tmp = new File(saveLocation);
//		File file = new File(findLocation);
//		List<String> dirList = new ArrayList<>();
//		
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp), "GBK"));
//		find(file, fileType, dirList);
//		
//		
//		Iterator<String> it = dirList.iterator();
//		while(it.hasNext()){
//			bufw.write(it.next().toString());
//			bufw.newLine();
//			bufw.flush();
//		}
//		
//		return tmp;
//	}

	/* 用字符串过滤方式 */
//	private static void find(File file, String fileType, List<String> objFile) {
//		
//		File[] files = file.listFiles();
//
//		for (int i = 0; i < files.length; i++) {
//			if(files[i].isDirectory()){
//				find(files[i],fileType, objFile);
//			}else {
//				if(files[i].toString().endsWith(fileType)){
//					objFile.add(files[i].toString());
//				}
//			}
//		}
//	}
	
	
//	/* 用过滤器过滤方式 */
//	private static File fun(String findLocation, FilenameFilter filter, String saveLocation) throws IOException {
//		File tmp = new File(saveLocation);
//		File file = new File(findLocation);
//		List<String> dirList = new ArrayList<>();
//		
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp), "GBK"));
//		find(file, filter, dirList);
//		
//		
//		Iterator<String> it = dirList.iterator();
//		while(it.hasNext()){
//			bufw.write(it.next().toString());
//			bufw.newLine();
//			bufw.flush();
//		}
//		
//		bufw.close();
//		return tmp;
//	}
//	
//	private static void find(File file, FilenameFilter filter, List<String> objFile) {
//		
//		File[] files = file.listFiles();
//
//		for (int i = 0; i < files.length; i++) {
//			if(files[i].isDirectory()){
//				find(files[i],filter, objFile);
//			}else {
//				if(filter.accept(files[i], file.getName())){
//					objFile.add(files[i].toString());
//				}
//			}
//		}
//	}
	


	/* 用过滤器过滤方式 */
	private static File fun(String findLocation, FilenameFilter filter, String saveLocation) throws IOException {
		File tmp = new File(saveLocation);
		File file = new File(findLocation);
		List<String> dirList = new ArrayList<>();
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp), "GBK"));
		find(file, filter, dirList);
		
		
		Iterator<String> it = dirList.iterator();
		while(it.hasNext()){
			bufw.write(it.next().toString());
			bufw.newLine();
			bufw.flush();
		}
		
		bufw.close();
		return tmp;
	}
	
	private static void find(File file, FilenameFilter filter, List<String> objFile) {
		
		File[] files = file.listFiles();

		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()){
				find(files[i],filter, objFile);
			}else {
				if(filter.accept(files[i], file.getName())){
					objFile.add(files[i].toString());
				}
			}
		}
	}
	
}



