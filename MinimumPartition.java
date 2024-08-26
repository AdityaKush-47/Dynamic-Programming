public class MinimumPartition {
    public static int partition(int arr[]) {
        int sum = sumOfArray(arr);
        int W = sum/2;
        int n = arr.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<W+1;j++) {
                int wt = arr[i-1];
                if(wt<=j) {
                    //Include
                    int incProfit = wt+dp[i-1][j-wt];
                    //Exclude
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                } else { // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static int sumOfArray(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        System.out.println(partition(arr));
    }
}
