

class objectDemo{
	public static void main(String[] args){
		
		Car c1 = new Car();
		Car c2 = new Car();
		carBulid(c1, 10, "blue");
		carBulid(c2, 20, "red");
		System.out.println("object Demo !");
		
		//匿名对象
		carBulid(new Car(), 30, "black");
		carBulid(new Car(), 40, "white");
		

		Person person = new Person();
		person.setAge(28);
		person.speak();
	}
	
	public static void carBulid(Car car, int num, String color)
	{
		car.num = num;
		car.color = color;
		System.out.println(car.num+"\t"+car.color);
	}
}


/*************<< 自建类 >>******************/
class Car{
	int num;
	String color;
	void carRun()
	{
		System.out.println("num is :"+num+"\t"+"color is ： "+color);
	}
}

class Person{
	private int age;
	public void setAge(int x){
		if((x>=0) && (x<=130)){
			age = x;
		}
		else 
			System.out.println("age error !");
	}
	
	public int getAge(){
		return age;
	}
	
	void speak(){
		System.out.println("age is : "+age);
	}
}
















