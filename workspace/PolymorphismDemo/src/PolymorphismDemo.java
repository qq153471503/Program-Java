

/**
 * 多态Demo ： 提高代码的扩展性，前期定义的代码可以使用后期的内容
 * 所有事物有共性内容 即可使用多态
 * instanceof : 用于判断对象的具体类型，只能用于引用数据类型判断
 * 
 * 对象的多态性，static方法一般不需要具有多态性，因为静态函数无需对象，可以使用类名.方法的方式直接使用。
 * */
public class PolymorphismDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun(new Dog());
		fun(new Cat());
		fun(new Wolf());
		
		//向上转型 目的：只访问共有事件
		Animal wolf = new Wolf();
		wolf.call();
		
		//向下转型 目的：为使用子类中的特有数据
		Wolf w = (Wolf)wolf;
		w.work();
		
		
		//成员变量：编译看左边  运行看左边  运行依赖对象
		Fu fu = new Zi();
		System.out.println(fu.num);
		
		//成员函数[非静态的]： 编译看左边 运行看右边，依赖引用
		Fu2 fu2 = new Zi2();
		fu2.show();
		
		//成员函数[静态的]：运行依赖引用
		fu2.funStatic();  
	}
	
	public static void fun(Animal animal){
		animal.call();
		if(animal instanceof Dog){
			Dog d = (Dog)animal;
			d.eat();
		}else if(animal instanceof Cat){
			Cat c = (Cat)animal;
			c.play();
		}else if(animal instanceof Wolf){
			Wolf w = (Wolf)animal;
			w.work();
		}
	}

}

interface Animal{
	public abstract void call();
}

class Dog implements Animal{
	public void call(){
		System.out.println("汪汪");
	}
	public void eat(){
		System.out.println("啃骨头");
	}
}

class Cat implements Animal{
	public void call(){
		System.out.println("喵喵");
	}
	public void play(){
		System.out.println("玩老鼠");
	}
}

class Wolf implements Animal{
	public void call() {
		System.out.println("嗷嗷");
	}
	public void work() {
		System.out.println("挖洞");
	}
}

//成员变量示例
class Fu{
	int num = 9;
}

class Zi extends Fu{
	int num = 10;
}

//成员函数示例  重点！
class Fu2{
	public void show() {
		System.out.println("Fu....show...");
	}
	
	public static void  funStatic() {
		System.out.println("Fu....static...");
	}
}

class Zi2 extends Fu2{
	public void show(){
		System.out.println("zi...show....");
	}

	public static void  funStatic() {
		System.out.println("Zi....static...");
	}
}



