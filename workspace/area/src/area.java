import java.util.*;
class areaDemo{
	public static void main(String[] args){
		
/*
 * 控制台基本输入输出
 * */
//		while(true)
		{
			Scanner input = new Scanner(System.in);
			System.out.print("请输入圆的半径： ");
			double r = input.nextDouble();
			System.out.print("圆的面积是： "+(r*r*3.141592654)+"\r\n");
			String ch = input.next();
			System.out.print("String is : "+ch+"\r\n");
			
		}
		
/*
 * 数学运算
 * */
		//计算次幂
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(4, 0.5));
		System.out.println(Math.pow(2.5, 2));
		System.out.println(Math.pow(2.5, -2));
		
/*
 * 获取格林威治时间 并转换成北京时间 格林威治时间与北京时间相差八小时
 * */
		long timeSeconds = System.currentTimeMillis() / 1000;
		long timeSecond = timeSeconds % 60;
		long timeMinutes = timeSeconds / 60;
		long timeMinute = timeMinutes % 60;
		long timeHours = timeMinutes / 60;
		long timeHour = timeHours % 24;
		System.out.println("GMT Current time is : "+timeHour+":"+timeMinute+":"+timeSecond);
		System.out.println("Beijing Current time is : "+(timeHour+8)+":"+timeMinute+":"+timeSecond);
	}
}

