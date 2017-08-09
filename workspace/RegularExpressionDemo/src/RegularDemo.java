/**
 * 【正则表达式】：正确规则的表达式
 * @author KunGe
 * 
 * 
 * 【需求】：定义一个功能，对qq号码进行校验
 * 				要求：5-11位，只能是数字，0不能开头
 *
 *
 *【正则表达式】：操作字符串，具有特定的符号
 */
public class RegularDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String qq = "12345";
//		checkQQ(qq);
		
		//定义规则   正则表达式
		String regex = "[1-9][0-9]{4,10}";
		
		System.out.println(qq.matches(regex));
	}

	private static void checkQQ(String qq) {
		int len = qq.length();
		
		if( len>=5 && len<=11 ){
			if(!qq.startsWith("0")){
				
				try {
					long l = Long.parseLong(qq);
					System.out.println(l+"正确");
				} catch (Exception e) {
					System.out.println(qq+"含有非法字符！");
				}
				
			}else {
				System.out.println("qq不能是0开头！");
			}
		}else {
			System.out.println("QQ号码长度错误！");
		}
	}

}
