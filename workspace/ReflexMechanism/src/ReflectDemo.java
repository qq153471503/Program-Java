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
 *	java反射机制是在运行状态中，对于任意一个类（class文件），都能够知道这个类的所有属性和方法；
 *	对于任意一个对象，都能够调用它的任意一个方法和属性
 *	这种动态获取的信息以及动态调用对象的方法的功能称为JAVA语言的反射机制。
 *
 *
 *
 *要想对字节码文件解剖，必须有字节码文件对象
 *获取字节码文件对象的方式有三：
 *1、Object中的getClass方法,想要用这种方式，必须要明确具体的类并且明确对象，麻烦
 *2、类名.class 相对1简单，还是需要类中的静态成员(.class就是静态成员)，不够扩展
 *3、只要通过给定的类的字符串，就可以 ，使用Class类
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

//		方式1
//		theWay_1();
		
//		方式二  
//		theWay_2();
		
//		方式三
//		theWay_3();
		
//		demo_1();
		demo_2();
		
	}

	private static void demo_2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
//		早期方式：
//		Persion p = new Persion("xiaoming",30);
		
		
//		现在方式：  更强的扩展性
		String name = "demo.Persion";
		
//		找寻名称类文件，加载进内存，并产生class对象
		Class clazz = Class.forName(name);
		
		/**
		 * 	产生该类对象,该类构造函数具有参数，开发者指定了带参数的构造函数
		 */
		
//		获取构造函数
		Constructor cons = clazz.getConstructor(String.class, int.class);	//获得该类的构造函数
		Object obj = cons.newInstance("小强",32);
		
//		获取字段    如果字段是私有的，必须取消访问检查
		Field field = clazz.getDeclaredField("name");
		
		//取消name变量的私有化
		field.setAccessible(true);	//暴力访问：不建议使用
		System.out.println(field);
		field.set(obj, "李明");		//更改 值
		Object o = field.get(obj);
		System.out.println(o);
		field.setAccessible(false);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
//		获取方法 
//		Method[] met = clazz.getMethods(); //只能获取共有方法
		Method[] met = clazz.getDeclaredMethods();	//获取所有方法
		for(Method method : met){
			System.out.println(method);
		}
		
		
		System.out.println();System.out.println();
		
		
//		获得一个方法  函数无参数
		Method method1 = clazz.getMethod("show", null); //获取show方法，空参数
		method1.invoke(obj, null);	//传入对象，函数参数为空 【注意】：此处传入的obj对象，在上面已经传入了参数，所以显示在控制台的是带参数的
		
		
//		函数有参数
		Method method2 = clazz.getMethod("paramMethod", String.class, int.class);
		method2.invoke(obj, "小李", 89);
	}

//	获取Class中的构造函数
	private static void demo_1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
//		早期方式：
//		Persion p = new Persion();
		
		
//		现在方式：  更强的扩展性
		String name = "demo.Persion";
		
//		找寻名称类文件，加载进内存，并产生class对象
		Class clazz = Class.forName(name);
		
		//产生该类对象   构造函数无参数
		Object obj = clazz.newInstance();
		
		
	}

	private static void theWay_3() throws ClassNotFoundException {
		Class c1 = Class.forName("demo.Persion");		//必须带包名
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
