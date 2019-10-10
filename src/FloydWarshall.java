public class FloydWarshall {
    private int n;
    private int[][] costs;
    private int[][] demands;

    private int[][] dist;
    private int[][] pred;
    
    private int[][] links;
    private int[][] capacities;

    /* Module 2: Shortest Paths Algorithm
     * 
     * Step 1: Use the Floyd Warshall algorithm to get the shortest distances and paths
     * shortest distances are stored in dist matrix
     * shortest paths are stored in pred matrix
     * pred[i][j] is the node having the maximum number in the shortest path between i and j.
     *  If there is no such node, pred[i][j]=-1
     *  
     *  Step 2: Increment capacities of links on the shortest path between i and j with demand[i][j], Repeat for all (i,j)
     *  
     *  Step 3: Compute cost and density of the obtained network */


    FloydWarshall(int[][] costs, int demands[][], int n) {
        this.costs = costs;
        this.demands = demands;
        this.n = n;
        this.pred = new int[n][n];
        this.links = new int[n][n];
        this.capacities = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pred[i][j] = -1;
                capacities[i][j] = 0;
                links[i][j] = 0;
                this.dist = costs;
            }
        }
    }
    
    /* run the shortest paths algorithm */
    public void runAlgorithm() {
        for (int r = 0; r < n; r++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][r] + dist[r][j] < dist[i][j]) {
                        dist[i][j] = dist[i][r] + dist[r][j];
                        pred[i][j] = r;
                    }
                }
            }
        }
        
        /* print the dist matrix */
        Utils.printMatrix(dist, n, "All pairs shortest paths distances");
        
        /* print the pred matrix */
        Utils.printMatrix(pred, n, "Predecessor matrix");
    }
    
    /* designing the network using the shortest path distances */
    public void designNetwork() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    adjustCapacities(i, j, demands[i][j]);
                }
            }
        }
        
        /* print the capacities matrix */
        Utils.printMatrix(capacities, n, "capacities");
        
        /* print the links matrix */
        Utils.printMatrix(links, n, "Links ");

    }

    /* compute the cost of the network */
    public int computeCost() {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)

            {
                total += capacities[i][j] * costs[i][j];
            }
        }
       
        return total;
    }
    
    /* compute the density of the network */
    public double computeDensity() {
        double density = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                density += links[i][j];
            }
        }
        return density / (n * (n - 1));
    }

    /* adjust capacities on links in a shortest path */
    public void adjustCapacities(int src, int dest, int val) {
        if (pred[src][dest] == -1) {
            capacities[src][dest] += val;
            links[src][dest] = 1;
            return;
        }
        adjustCapacities(src, pred[src][dest], val);
        adjustCapacities(pred[src][dest], dest, val);
    }

    /* print the shortest path between nodes src and dest */
    public void printPath(int src, int dest) {
        System.out.print("Path from " + src + " to " + dest + " : ");
        getPath(src, dest);
        System.out.println("\n");
    }
    
    /* print nodes in the shortest path between nodes src and dest */
    public void getPath(int src, int dest) {


        if (pred[src][dest] == -1) {
            System.out.print(" ");
            return;
        }
        getPath(src, pred[src][dest]);
        System.out.print(" " + pred[src][dest]);
        getPath(pred[src][dest], dest);


    }

  


}