import java.util.*;
class areaDemo{
	public static void main(String[] args){
		
/*
 * ����̨�����������
 * */
//		while(true)
		{
			Scanner input = new Scanner(System.in);
			System.out.print("������Բ�İ뾶�� ");
			double r = input.nextDouble();
			System.out.print("Բ������ǣ� "+(r*r*3.141592654)+"\r\n");
			String ch = input.next();
			System.out.print("String is : "+ch+"\r\n");
			
		}
		
/*
 * ��ѧ����
 * */
		//�������
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(4, 0.5));
		System.out.println(Math.pow(2.5, 2));
		System.out.println(Math.pow(2.5, -2));
		
/*
 * ��ȡ��������ʱ�� ��ת���ɱ���ʱ�� ��������ʱ���뱱��ʱ������Сʱ
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
