public class hello{
	
	public static void main(String[] args){
		
		/* ¾Å¾Å³Ë·¨±í */
		
		for(int x=1; x<10; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+(x*y)+"\t");
			}
			System.out.println();
		}
		
		for(int x=1; x<=5; x++)
		{
			for(int y=1; y<x; y++)
			{
				System.out.print("-");
			}
			
			for(int z=x; z<=5; z++)
				System.out.print("* ");
			System.out.println();
		}
		
		for(int x1=0; x1<=3; x1++)
		{
			if(x1 == 2)
				continue;
			System.out.print("x1 is === : "+x1+"\n");
		}
	}
}

