import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import demo.Persion;

/**
 * 
 * @author KunGe
 *
 *
 *	java���������������״̬�У���������һ���ࣨclass�ļ��������ܹ�֪���������������Ժͷ�����
 *	��������һ�����󣬶��ܹ�������������һ������������
 *	���ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�ΪJAVA���Եķ�����ơ�
 *
 *
 *
 *Ҫ����ֽ����ļ����ʣ��������ֽ����ļ�����
 *��ȡ�ֽ����ļ�����ķ�ʽ������
 *1��Object�е�getClass����,��Ҫ�����ַ�ʽ������Ҫ��ȷ������ಢ����ȷ�����鷳
 *2������.class ���1�򵥣�������Ҫ���еľ�̬��Ա(.class���Ǿ�̬��Ա)��������չ
 *3��ֻҪͨ������������ַ������Ϳ��� ��ʹ��Class��
 */
public class ReflectDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

//		��ʽ1
//		theWay_1();
		
//		��ʽ��  
//		theWay_2();
		
//		��ʽ��
//		theWay_3();
		
//		demo_1();
		demo_2();
		
	}

	private static void demo_2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
//		���ڷ�ʽ��
//		Persion p = new Persion("xiaoming",30);
		
		
//		���ڷ�ʽ��  ��ǿ����չ��
		String name = "demo.Persion";
		
//		��Ѱ�������ļ������ؽ��ڴ棬������class����
		Class clazz = Class.forName(name);
		
		/**
		 * 	�����������,���๹�캯�����в�����������ָ���˴������Ĺ��캯��
		 */
		
//		��ȡ���캯��
		Constructor cons = clazz.getConstructor(String.class, int.class);	//��ø���Ĺ��캯��
		Object obj = cons.newInstance("Сǿ",32);
		
//		��ȡ�ֶ�    ����ֶ���˽�еģ�����ȡ�����ʼ��
		Field field = clazz.getDeclaredField("name");
		
		//ȡ��name������˽�л�
		field.setAccessible(true);	//�������ʣ�������ʹ��
		System.out.println(field);
		field.set(obj, "����");		//���� ֵ
		Object o = field.get(obj);
		System.out.println(o);
		field.setAccessible(false);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
//		��ȡ���� 
//		Method[] met = clazz.getMethods(); //ֻ�ܻ�ȡ���з���
		Method[] met = clazz.getDeclaredMethods();	//��ȡ���з���
		for(Method method : met){
			System.out.println(method);
		}
		
		
		System.out.println();System.out.println();
		
		
//		���һ������  �����޲���
		Method method1 = clazz.getMethod("show", null); //��ȡshow�������ղ���
		method1.invoke(obj, null);	//������󣬺�������Ϊ�� ��ע�⡿���˴������obj�����������Ѿ������˲�����������ʾ�ڿ���̨���Ǵ�������
		
		
//		�����в���
		Method method2 = clazz.getMethod("paramMethod", String.class, int.class);
		method2.invoke(obj, "С��", 89);
	}

//	��ȡClass�еĹ��캯��
	private static void demo_1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
//		���ڷ�ʽ��
//		Persion p = new Persion();
		
		
//		���ڷ�ʽ��  ��ǿ����չ��
		String name = "demo.Persion";
		
//		��Ѱ�������ļ������ؽ��ڴ棬������class����
		Class clazz = Class.forName(name);
		
		//�����������   ���캯���޲���
		Object obj = clazz.newInstance();
		
		
	}

	private static void theWay_3() throws ClassNotFoundException {
		Class c1 = Class.forName("demo.Persion");		//���������
		Class c2 = Class.forName("demo.Persion");
		System.out.println(c1==c2);
	}

	private static void theWay_2() {
		Class c = Persion.class;
		Class c2 = Persion.class;
		System.out.println(c==c2);
	}

	private static void theWay_1() {
		Persion p = new Persion();
		Class c1 = p.getClass();
		
		Persion p1 = new Persion();
		Class c2 = p1.getClass();
		
		System.out.println(c1==c2);
	}

}