public class Climbing_Stairs {
    // Recursive Code
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // Memoization
    public static int countWaysMemoize(int n, int dp[]) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = countWaysMemoize(n - 1, dp) + countWaysMemoize(n - 2, dp);
        }
        return dp[n];
    }

    // Tabulation
    public static int countWaysTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + ((i - 2) < 0 ? 0 : dp[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        // int dp[] = new int[n + 1];
        // System.out.println("Number of Ways to climb " + n + "th stair are : " +
        // countWaysMemoize(n, dp));
        // System.out.println("Number of Ways to climb " + n + "th stair are : " +
        // countWays(n));
        System.out.println(countWaysTabulation(n));
    }
}
