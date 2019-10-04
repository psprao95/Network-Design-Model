
public class FloydWarshall {
	
	private  int[][] dist;
	private int[][]pred;
	private int n;
	private  int[][] costs;
	private int[][] demands;
	
	private int [][]links;
	private int[][] capacities;
	
	/* DP approach to get all pairs shortest paths matrix
	 * uses the Floyd Warshall algorithm
	 * 
	 */
	
	FloydWarshall(int[][] costs, int demands[][], int n)
	{
		this.costs=costs;
		this.demands=demands;
		this.n=n;
		this.pred=new int[n][n];
		this.links=new int[n][n];
		this.capacities=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				pred[i][j]=-1;
				capacities[i][j]=0;
				links[i][j]=0;
				this.dist=costs;
			}
		}
	}
	
	public void runAlgorithm()
	{
		
		
		
		
		
		
		for(int r=0;r<n;r++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(dist[i][r]+dist[r][j]<dist[i][j])
					{
						dist[i][j]=dist[i][r]+dist[r][j];
						pred[i][j]=r;
					}
				}
			}
		}
		
		Utils.printMatrix(dist, n, "All pairs shortest paths distances");
	}
		
	public void designNetwork()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j) {
				adjustCapacities(i,j,demands[i][j]);}
			}
		}
		Utils.printMatrix(capacities, n, "capacities");
		Utils.printMatrix(links, n, "Links ");
		
	}
		
	
	public int computeCost()
	{
		int total=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				
			{
				total+=capacities[i][j]*costs[i][j];
			}
		}
		System.out.println("COst of network: "+total);
		return total;
	}

	
	public void adjustCapacities(int src,int dest,int val)
	{
		if(pred[src][dest]==-1)
		{
			capacities[src][dest]+=val;
			links[src][dest]=1;
			return;
		}
		adjustCapacities(src,pred[src][dest],val);
		adjustCapacities(pred[src][dest],dest,val);
	}
	
	public void printPath(int src, int dest)
	{
		System.out.print("Path from "+src+" to "+dest+" : ");
		getPath(src,dest);
		System.out.println("\n");
	}
	public void getPath( int src, int dest)
	{
		
	
		if(pred[src][dest]==-1)
		{
			System.out.print(" ");
			return;
		}
		getPath(src,pred[src][dest]);
		System.out.print(" "+pred[src][dest]);
		getPath(pred[src][dest],dest);
		
		
	}
	
	public int[][] getLinks()
	{
		return links;
	}
	
	public int[][] getCapacities()
	{
		return capacities;
	}
	
	
}
