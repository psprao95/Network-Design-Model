import java.util.Scanner;

public class NetworkDesignModel {

	
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int n=20;
		
		 
		/*System.out.println("Enter the number of processes:");
		//System.out.println("Number of nodes: "+n);
		sc.close();
		*/
		
		/* module 1 */
		int numk=11;
		int[] costArray=new int[numk];
		int[] kmatrix=new int[numk];
		for(int i=0;i<numk;i++)
		{
			costArray[i]=0;
			kmatrix[i]=i+3;
		}
		
		for(int i=0;i<numk;i++)
		{
			int k=kmatrix[i];
		
		
		
		CostDemandGeneration c = new CostDemandGeneration(n,k);
		
		/* Generating the demand matrix*/
		int[][] demands=c.getDemandMatrix();
		int[][]costs=c.getCostMatrix();
		
		/* Module 2 : Shortest Paths*/
		FloydWarshall f= new FloydWarshall(costs,demands,n);
		f.runAlgorithm();
		f.designNetwork();
		int capacities[][]=f.getCapacities();
		int links[][]=f.getLinks();
		int cost=f.computeCost();
		costArray[i]=cost;
	}
		
		Analysis a =new Analysis(costArray,kmatrix,numk);
		a.runAnalysis();
		
	}
}
