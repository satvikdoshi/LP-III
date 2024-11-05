package Assignment3;

import java.util.Arrays;

class Solution {
    static int solve(int index, int weight, int[] wt, int[] val, int[][] dp) {
        // Base condition
        if (index == 0) {
            // If the weight of the first item is within the weight limit, return its value, else return 0
            if (wt[0] <= weight)
                return val[0];
            return 0;
        }

        if (dp[index][weight] != -1)
            return dp[index][weight];

        // Not picking the current item
        int notPick = solve(index - 1, weight, wt, val, dp);

        // Picking the current item if its weight is within the remaining capacity
        int pick = 0;
        if (wt[index] <= weight) {
            pick = val[index] + solve(index - 1, weight - wt[index], wt, val, dp);
        }

        // Store and return the maximum value between picking and not picking
        return dp[index][weight] = Math.max(notPick, pick);
    }

    // Function to return the maximum value that can be put in the knapsack of capacity W.
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(n - 1, W, wt, val, dp);
    }

    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

        System.out.println(knapSack(5, wt, val, wt.length)); 
    }
}
