
public class FloydWarshallAPSP {
	
	private static int[][] dist;
	private static int[][] pred;
	private static int[][] costs;
	/* DP approach to get all pairs shortest paths matrix
	 * 
	 * 
	 */
	
	FloydWarshallAPSP()
	{
		
	}
	public static void getAPSPMatrix(int[][] a,int[][] demands,int n)
	{
		int[][] pred=new int[n][n];
		int capacities[][]=new int[n][n];
		int links[][]=new int[n][n];
		
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				pred[i][j]=i;
				capacities[i][j]=0;
				links[i][j]=0;
			}
		}
		
		for(int r=0;r<n;r++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(a[i][r]+a[r][j]<a[i][j])
					{
						a[i][j]=a[i][r]+a[r][j];
						pred[i][j]=pred[r][j];
					}
				}
			}
		}
		
		pred=pred;
		dist=a;
		//getPath(3,7);
		
		Utils.printMatrix(a,n,n, "Shortest distance by costs matrix");
		Utils.printMatrix(pred,n,n,"predecessor matrix");
		/*Utils.printMatrix(capacities, n, n, "capaciy matrix");
		Utils.printMatrix(links, n, n, "Links matrix");
		*/
	}
	
	
	public static void getPath( int src, int dest)
	{
		
	
		if(pred[src][dest]==src)
		{
			System.out.print(" ");
		}
		getPath(src,pred[src][dest]);
		System.out.print(" "+pred[src][dest]);
		getPath(pred[src][dest],dest);
		
	}
	
	
}
