import java.util.Calendar;


public class CalendarDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		demo_1();
	}

	private static void demo_1() {
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
	}
	

}
