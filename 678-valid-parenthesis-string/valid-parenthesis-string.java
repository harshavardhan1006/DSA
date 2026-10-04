class Solution {
    int[][] dp;
    int fun(int i,int cnt,String s){
        if(cnt < 0) return 0;
        if(i == s.length()) return cnt == 0 ? 1 : 0;
        if(dp[i][cnt] != -1) return dp[i][cnt];
        char ch = s.charAt(i);
        if(ch == '(') return dp[i][cnt] = fun(i+1,cnt+1,s);
        else if(ch == ')') return dp[i][cnt] = fun(i+1,cnt-1,s);
        return dp[i][cnt] = Math.max(fun(i+1,cnt,s),Math.max(fun(i+1,cnt+1,s),fun(i+1,cnt-1,s)));
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new int[n][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return fun(0,0,s) == 1 ? true : false;
    }
}