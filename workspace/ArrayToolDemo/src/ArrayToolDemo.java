class ArrayToolDemo{
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		
		int arr2[] = {};
		
		int arr3[] = {12,125,564,4651};
		int arr4[] = {13,46,85,96,76};
		
//		ArraryFunction tool = new ArraryFunction();
		
//		System.out.println("Array Max is:"+(tool.getArrayMax(arr2)));
//		System.out.println("Array Max is:"+(tool.getArrayMax(arr)));
		System.out.println("Array Max is:"+ArrayFunction.getArrayMax(arr3));
		System.out.println("Array Max is:"+ArrayFunction.getArrayMax(arr4));
		System.out.println("Array Max is:"+ArrayFunction.array2string(arr4));
	} //end of void main()

}//end of ArrayToolDemo



