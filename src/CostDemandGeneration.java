
import java.lang.Math;
import java.util.ArrayList;

import java.util.List;

public class CostDemandGeneration {
	
	private int range;
	private int low;
	private int high;
	
	CostDemandGeneration()
	{
		
	}
	
	
	public  List<Integer> kRandomIndices(int k, int row)
	{
		System.out.print("generating "+k +" random indices for node "+row+" : ");
		List<Integer> list=new ArrayList<Integer>();int t;
		while(list.size()!=k)
		{
		
			t=(int)(Math.random()*(range))+low;
			if(!list.contains(t) && t!=row)
			{
				list.add(t);
				
				System.out.print(t+" ");
			}
		}	
		
		System.out.println("\n");
		
		return list;
		
	}
	
	public int[][] getDemandMatrix(int n)
	{
		int[] arr=new int[] {2,0,2,1,4,0,5,4,2,7};
		int demands[][]=new int[20][20];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				demands[i][j]=Math.abs(arr[i%10]-arr[j%10]);
				
			}
			
		}
		
		
		/* print the demand matrix*/
	
		Utils.printMatrix(demands,n,"Demand matrix");
		return demands;
	}
	
	public  int[][] getCostMatrix(int k, int n)
	{
		
		
		/* set range for generating random indices for cost matrix*/
		this.low=0;
		this.high=n-1;
		this.range=high-low+1;
		
		
		/* Generating the cost matrix*/
		System.out.println("Generating cost matrix for k= "+k+" ...");
		int[][] costs=new int[n][n];
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			list=kRandomIndices(k,i); 
			for(int j=0;j<n;j++)
			{
				if(i==j)
				{
					costs[i][j]=0;
				}
				else if(list.contains(j))
				{
					costs[i][j]=1;
				}
				else
				{
					costs[i][j]=100;
				}
				
			}
			
		}
		
		
		
		Utils.printMatrix(costs,n, "Cost matrix:");
		
		return costs;
		
		
		
		
	}
}
