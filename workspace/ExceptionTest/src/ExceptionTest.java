
public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new Student("LiuAnkun").setOff(2);
		new Student("LiuAnkun").setOff(1);
		new Student("LiuAnkun").setOff(0);
	}

}



class SoldOutException extends Exception{
	SoldOutException(){
		
	}
	
	SoldOutException(String msg){
		super(msg);
	}
}

class CarLaterException extends Exception{
	CarLaterException(){
		
	}
	CarLaterException(String msg){
		super(msg);
	}
}

class Go2Shool {

	private int status = 0;
	private String name=null;
	 Go2Shool() {
		 System.out.print("go to school ...\n");
	}
	 
	 Go2Shool(String name){
		 this.name = name;
		 System.out.print(this.name+"..."+"go to school ...\n");
	 }
	 
	 public void goToSchool(int status) throws SoldOutException,CarLaterException {
		this.status = status;
		if(this.status == 1)
			throw new CarLaterException("The train was late");
		if(this.status == 2)
			throw new SoldOutException("Tickets sold out");
		
		System.out.print("To get to school !");
	}
}


class Student {
	private Go2Shool gh;
	private String name;
	
	private int status = 0;
	Student(String name){
		this.name = name;
		gh = new Go2Shool(this.name);
	}
	
	public void setOff(int status){
		this.status = status;
		try {
			
			gh.goToSchool(this.status);
			
		} catch (SoldOutException se) {
			
			se.printStackTrace();
			
		} catch (CarLaterException ce) {
			
			ce.printStackTrace();
			
		} finally {
			
			System.out.print("千辛万险到达学校！\n");
		}
	}
}



