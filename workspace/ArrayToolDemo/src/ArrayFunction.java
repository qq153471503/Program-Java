
/**
 * �ļ�˵��������һ�����ڲ���������࣬���а����������һϵ�в������������������ֵ�ȡ�
 * @author 153471503@qq.com
 * @version v1.0
 * */
//�����еķ������Ǿ�̬�ģ����Ը������贴������ ���Խ����캯��˽�л���ǿ�Ʋ���������
public class ArrayFunction {

	private ArrayFunction () {
		
	}
	/**
	 * ������飺 �������Ԫ���е����ֵ�������ء�
	 * @param arr ���������
	 * @return �����е�Ԫ�����ֵ
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
	 * ������飺�������е�Ԫ��ת�����ַ����������ء�
	 * @param arr ���������
	 * @return str ת������ַ���
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