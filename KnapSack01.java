import java.util.Arrays;
public class KnapSack01 {

    //Recursive Code
    public static int knapSack(int wt[],int val[],int W,int i) {
        if(i==val.length || W<=0) {
            return 0;
        }
        if(wt[i]<=W) {
            int ans1 = val[i]+knapSack(wt, val, W-wt[i], i+1);
            int ans2 = knapSack(wt, val, W, i+1);

            return Math.max(ans1,ans2);
        } else {
            return knapSack(wt, val, W, i+1);
        }
    }

    //Memoization
    public static int knapSackMemoize(int []wt,int []val,int W,int i,int dp[][]) {
        if(i==0 || W<=0) {
            return 0;
        }
        if(dp[i][W] != -1) {
            return dp[i][W];
        }
        if(wt[i-1]<=W) {
            //Include
            int ans1 = val[i-1]+knapSackMemoize(wt, val, W-wt[i-1], i-1, dp);
            //Exclude
            int ans2 = knapSackMemoize(wt, val, W, i-1, dp);
            dp[i][W] = Math.max(ans1,ans2);
            return dp[i][W];
        } else {
            dp[i][W] = knapSackMemoize(wt, val, W, i-1, dp);
            return dp[i][W];
        }
    }

    //Tabulation
    public static int knapSackTabulation(int wt[],int val[],int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0;i<=n;i++) {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=W;i++) {
            dp[0][i] = 0;
        }

        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<W+1;j++) {
                int v = val[i-1];//ith item val
                int w = wt[i-1];//ith item wt
                if(w<=j) { // valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                } else { // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int []wt = {6 ,3 ,8 ,6 ,9 ,8 ,2 ,4 ,10, 9};
        int []val = {2, 1, 3, 1, 4, 1, 2, 2, 5, 7};
        int W = 4;
        int dp[][] = new int[val.length+1][W+1];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }
        //System.out.println(knapSack(wt, val, W, 0));
       // System.out.println(knapSackMemoize(wt, val, W, val.length, dp));
        System.out.println(knapSackTabulation(wt, val, W));
    }
}
