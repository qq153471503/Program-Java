
/**
 * 文件说明：建立一个用于操作数组的类，其中包含对数组的一系列操作，例如排序、照最大值等。
 * @author 153471503@qq.com
 * @version v1.0
 * */
//该类中的方法都是静态的，所以该类无需创建对象 所以将构造函数私有化，强制不创建对象
public class ArrayFunction {

	private ArrayFunction () {
		
	}
	/**
	 * 函数简介： 获得数组元素中的最大值，并返回。
	 * @param arr 传入的数组
	 * @return 数组中的元素最大值
	 * */
	public static int getArrayMax(int[] arr){

		if(arr.length <= 0)
		{
			System.out.println("Array Error !");
			return -1;
		}

		int max = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]>arr[max])
				max = i;
		}
		return arr[max];
	}
	/**
	 * 函数简介：将数组中的元素转换成字符串，并返回。
	 * @param arr 传入的数组
	 * @return str 转换后的字符串
	 * */
	public static String array2string(int[] arr) {
		String str = "[";
		for(int i=0; i<arr.length; i++)
		{
			str += arr[i];
		}
		str += ']';
		return str;
	}
}
