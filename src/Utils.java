
public class Utils {
	public static void printMatrix(int[][] arr, int n, int m, String s)
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
}
