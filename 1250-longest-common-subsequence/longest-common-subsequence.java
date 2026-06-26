class Solution {
    private static int lcs(int i1,int i2,String text1,String text2,int[][] dp){
        if(i1 < 0 || i2 < 0) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(text1.charAt(i1) == text2.charAt(i2)) return dp[i1][i2] = 1 + lcs(i1-1,i2-1,text1,text2,dp);
        return dp[i1][i2] =  Math.max(lcs(i1-1,i2,text1,text2,dp),lcs(i1,i2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return lcs(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}