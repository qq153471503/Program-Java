
/**
 * 
	 �ӿ�Interface
	1. �ӿ��еĳ�Ա����Ĭ�϶���public��static��final���͵ģ����뱻��ʽ��ʼ��
	2. �ӿ��еķ���Ĭ�϶���public��abstract���͵ġ�
	3. �ӿ���ֻ�ܰ���public��static��final���͵ĳ�Ա������public��abstract���͵ĳ�Ա������
	4. �ӿ�û�й��췽�������ܱ�ʵ�������ڽӿ��ж��幹�췽���ǷǷ��ġ�
	5. һ���ӿڲ���ʵ����һ���ӿڣ��������Լ̳ж�������ӿڡ�
	
*/
public class InterfaceDemoTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone phone = new Phone();
		useUSB(phone);
		
		useUSB(new Phone());
		phone.call();
		
		new Phone().close();
		
	}
	
	public static void useUSB(USB usb){
		if(usb != null)
			usb.open();
	}

}

interface USB{
	abstract  public void open();
	abstract  public void close();
}

class Phone implements USB{
	public void open(){
		System.out.println("USB open...");
	}
	
	public void close(){
		System.out.println("USB close...");
	}
	public void call() {
		System.out.println("Phone call...");
	}
}



