package dpAlgorithms;


class O1_Knapsack {
 
    static int max(int a, int b) { 
    	return (a > b)? a : b; 
    }
      
    static int knapSack(int MW, int weight[], int price[], int N)
    {
    	int i,w;
        int[][] K = new int[N+1][MW+1];
        for(i=0; i<=N; i++) {
            for(w=0; w<=MW; w++) {
                if (i==0 || w==0)           K[i][w] = 0;
                else if (weight[i-1] <= w)  K[i][w] = max(price[i-1]+K[i-1][w-weight[i-1]], K[i-1][w]);
                else                        K[i][w] = K[i-1][w];
            }
        }

        return K[N][MW];
    }
 
    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  MW = 50;
        int N = val.length;
        
        System.out.println(knapSack(MW, wt, val, N));
    }
}