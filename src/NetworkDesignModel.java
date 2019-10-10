import java.util.ArrayList;
public class NetworkDesignModel {

    /* Module 3: ANalysis and Presentation of Results */
    public static void main(String[] args) {

        /* Number of nodes */
        int n = 20;

        //simulateTestCase(n,3);
        //simulateTestCasesForRangeOfK(n,3,14);
        simulateTestCase(n, 8);
        simulateTestCase(n, 14);

    }

    /* Simulate the model for a given value of k */
    public static void simulateTestCase(int n, int k) {
        CostDemandGeneration c = new CostDemandGeneration(n);

        /* Generating the demand matrix*/
        int[][] demands = c.getDemandMatrix();

        int[][] costs = c.getCostMatrix(k);


        /* Module 2 : Shortest Paths*/
        FloydWarshall f = new FloydWarshall(costs, demands, n);
        f.runAlgorithm();
        f.designNetwork();
        int cost = f.computeCost();
        double density = f.computeDensity();
        System.out.println("k= " + k + " cost= " + cost + " density= " + density);

    }

    /* Simulate the model for a range [a,b] of values of k  */
    public static void simulateTestCasesForRangeOfK(int n, int a, int b) {

        ArrayList < Integer > kValues = new ArrayList < Integer > ();
        ArrayList < Integer > total_cost = new ArrayList < Integer > ();
        ArrayList < Double > densities = new ArrayList < Double > ();
        CostDemandGeneration c = new CostDemandGeneration(n);

        /* Generating the demand matrix*/
        int[][] demands = c.getDemandMatrix();

        for (int k = a; k <= b; k++) {
            kValues.add(k);

            int[][] costs = c.getCostMatrix(k);


            /* Module 2 : Shortest Paths algorithm*/
            FloydWarshall f = new FloydWarshall(costs, demands, n);
            f.runAlgorithm();
            f.designNetwork();


            /* compute the total cost of the network */
            int cost = f.computeCost();
            total_cost.add(cost);

            /* compute the density of the network */
            double density = f.computeDensity();
            densities.add(density);


        }

        for (int i = 0; i < kValues.size(); i++) {
            //System.out.println(kValues.get(i)+","+total_cost.get(i)+","+densities.get(i));
            System.out.println("k=" + kValues.get(i) + " cost=" + total_cost.get(i) + " density=" + densities.get(i));


        }

    }
}