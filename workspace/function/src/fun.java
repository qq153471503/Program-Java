
public class fun{

	public static void main(String[] args)
	{
		System.out.print("Function demo test !\n");
		System.out.print(add(1,2));	
		myprintf("\nliuankun\n");
		
		if(equals(5, 5))
		{
			myprintf("��ϵ����");
			myprintf('B');
			myprintf('\n');
		}
		
		print99();
		
		char ch = getLevel(98);
		
		System.out.print(ch);
	}
	
	public static void myprintf(String p)
	{
		System.out.print(p);
	}
	
	public static void myprintf(char ch)
	{
		System.out.print(ch);
	}
	
	static int add(int a, int b)
	{
		return a + b;
	}
	
	public static boolean equals(int a, int b)
	{
//		if(a == b)
//			return true;
//		else
//			return false;
//		return a==b?true:false;
		return a==b;
	}
	
	public static void print99()
	{
		for(int x=1; x<=9; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+(y*x)+"\t");
			}
			System.out.println();
		}
	}
	
	public static char getLevel(int sco)
	{
		char lev='\0';
		if( (sco>=90) && lev<= 100)
			lev = 'A';
		else if(sco>=80 && lev<90)
			lev = 'B';
		else 
			return 'C';
		return lev;
	}
}	

