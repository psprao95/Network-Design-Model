

public class Analysis 
{
	int arr[];
	int kmatrix[];
	int n;

	Analysis(int[] costArray, int[] kmatrix,int numk)
	{
		this.arr=costArray;
		this.kmatrix=kmatrix;
		this.n=numk;
	}
	
	
	public void runAnalysis()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("k="+kmatrix[i]+" Cost="+arr[i]);
		}
	}
}
