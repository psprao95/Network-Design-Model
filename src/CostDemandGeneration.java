import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

import java.util.List;

public class CostDemandGeneration {
	
	private static int range;
	private static int low;
	private static int high;
	
	
	public static List<Integer> kRandomIndices(int k, int row)
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
	
	
	
	public  static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=20;
		 
		/*System.out.println("Enter the number of processes:");
		//System.out.println("Number of nodes: "+n);
		sc.close();
		*/
		
		/* Student Id */
		int[] arr=new int[] {2,0,2,1,4,0,5,4,2,7};
		
		/* Generating the demand matrix*/
		int demands[][]=new int[20][20];
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				demands[i][j]=Math.abs(arr[i%10]-arr[j%10]);
				
			}
			
		}
		
		/* print the demand matrix*/
	
		Utils.printMatrix(demands,n,n,"Demand matrix");
		
		/* set range for generating random indices for cost matrix*/
		low=0;
		high=n-1;
		range=high-low+1;
		
		
		
		
		
		/* Generating the cost matrix*/
		int k=5;
		System.out.println("Value of k: "+k);
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
		
		
		
		Utils.printMatrix(costs,n,n, "Cost matrix:");
		FloydWarshallAPSP.getAPSPMatrix(costs,demands,n);
		
		
		
		
		
	}
}
