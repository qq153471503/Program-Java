/**
 * ���������ʽ������ȷ����ı���ʽ
 * @author KunGe
 * 
 * 
 * �����󡿣�����һ�����ܣ���qq�������У��
 * 				Ҫ��5-11λ��ֻ�������֣�0���ܿ�ͷ
 *
 *
 *���������ʽ���������ַ����������ض��ķ���
 */
public class RegularDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String qq = "12345";
//		checkQQ(qq);
		
		//�������   �������ʽ
		String regex = "[1-9][0-9]{4,10}";
		
		System.out.println(qq.matches(regex));
	}

	private static void checkQQ(String qq) {
		int len = qq.length();
		
		if( len>=5 && len<=11 ){
			if(!qq.startsWith("0")){
				
				try {
					long l = Long.parseLong(qq);
					System.out.println(l+"��ȷ");
				} catch (Exception e) {
					System.out.println(qq+"���зǷ��ַ���");
				}
				
			}else {
				System.out.println("qq������0��ͷ��");
			}
		}else {
			System.out.println("QQ���볤�ȴ���");
		}
	}

}