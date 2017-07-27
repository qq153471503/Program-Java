/*
 * 堆：所有对象  new出来的变量
 * 栈：局部变量 
 * 
 * */

public class array{
	static int i = 210;
	public static void main(String[] args){
		char[] arr = new char[3];
		System.out.println(arr);
		System.out.println("array demo !\n");
		System.out.println(i);
		arr = null;
		int[] tab = new int[]{1,2,3};
		System.out.println(tab[2]);
		int[] tab2 = {1,2,3};
		for(int x=0; x<tab2.length; x++)
			System.out.println("tab2["+x+"] : "+tab2[x]);
		int[] maxVal = new int[]{12,999,465,47};
//		System.out.println(getMax(maxVal));
		sortMax2Min(maxVal);
		for(int x=0; x<maxVal.length; x++)
			System.out.println(maxVal[x]);
		
		int[][] arr2 = {{1,1,1},
						{2,2,2},
						{3,3,3}};
		
		for(int i=0; i<3; i++)
		{
			for(int k=0; k<3; k++)
			{
				System.out.print(arr2[i][k]);
			}
			System.out.print("\n");
		}
		
		int arr3[] = new int[10];
	}
	
/**********************************************************************/
	
/*
 * 获取数组中最大数方法实现
 * */
	public static int getMax(int[] arr)
	{
		int max = arr[0];
		for(int cnt=1; cnt<arr.length; cnt++)
		{
			if(arr[cnt]>max)
				max = arr[cnt];
		}
		return max;
	}
	
/*
 * 冒泡排序方法实现
 * */
	public static void sortMax2Min(int[] arr)
	{
//		int tmp=arr[0];
		for(int i=0; i<arr.length-1; i++)
		{
			if( arr[i+1] > arr[i] )
			{
//				tmp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = tmp;
				swap(arr, i+1, i);
			}
		}
	}
	
/*
 * 位置数据交换方法
 * */
	public static void swap(int[] arr, int n, int n2)
	{
		int tmp = arr[n];
		arr[n] = arr[n2];
		arr[n2] = tmp;
	}
}


