
public class Utils {
	public static void printMatrix(int[][] arr, int n, String s)
	{
		System.out.println(s);
		
		for(int i=0;i<n;i++)
		{
			System.out.print("row "+i+" : ");
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	
	public static void printMatrix1D (int []arr, int n,String s)
	{
System.out.println(s);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
			
			
	}System.out.println("\n");
	}
	
	
}
