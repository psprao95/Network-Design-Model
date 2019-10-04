import java.util.Scanner;

public class NetworkDesignModel {

	
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int n=20;
		int k=7;
		 
		/*System.out.println("Enter the number of processes:");
		//System.out.println("Number of nodes: "+n);
		sc.close();
		*/
		
		/* Student Id */
		CostDemandGeneration c = new CostDemandGeneration();
		
		/* Generating the demand matrix*/
		int[][] demands=c.getDemandMatrix(n);
		int[][]costs=c.getCostMatrix(k, n);
		
		/* Module 2 : Shortest Paths*/
		FloydWarshall f= new FloydWarshall(costs,demands,n);
		f.getAPSPMatrix();
		f.designNetwork();
		f.computeCost();
		
	}
}
