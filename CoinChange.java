public class CoinChange {
    public static int coinChange(int coin[],int sum) {
        int n = coin.length;
        int dp[][] = new int[n+1][sum+1];

        for(int i = 0 ;i<n+1;i++) {
            dp[i][0] = 1;
        }
        for(int i = 0;i<sum+1;i++) {
            dp[0][i] = 0;
        }

        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<sum+1;j++) {
                if(j>=coin[i-1]) {
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int coin[] = {1,2,5};
        int sum = 11;
        System.out.println(coinChange(coin, sum));
    }
}
