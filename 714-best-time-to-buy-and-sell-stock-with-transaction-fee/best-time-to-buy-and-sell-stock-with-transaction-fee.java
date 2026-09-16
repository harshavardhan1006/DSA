class Solution {
    static int[][] dp;
    private static int fun(int i,int[] prices,int buy,int fee){
        if(i >= prices.length) return 0;
        int profit = 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        // System.out.println(i);
        if(buy == 1){
            profit = Math.max(-prices[i]+fun(i+1,prices,0,fee),fun(i+1,prices,1,fee));
        }else{
            profit = Math.max(prices[i]-fee+fun(i+1,prices,1,fee),fun(i+1,prices,0,fee));
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(0,prices,1,fee);
    }
}