import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 【练习题】：比较两个时间的大小
 * @author KunGe
 *
 */
public class DatePriactice {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {

		String date1 = "2017/8/1";
		String date2 = "2017/8/10";
		
		test(date1, date2);
	}

	private static void test(String date1, String date2) throws ParseException {
		DateFormat df = DateFormat.getDateInstance();
		df = new SimpleDateFormat("yyyy/MM/dd");
		
	}

}
