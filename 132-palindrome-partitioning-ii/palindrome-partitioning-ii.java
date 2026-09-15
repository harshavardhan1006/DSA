class Solution {
    static int[] dp;
    private static int fun(int i,String s){
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int cut = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                int cnt = 1+fun(j+1,s);
                cut = Math.min(cut,cnt);
            }
        }
        return dp[i] = cut;
    }
    private static boolean isPalindrome(int i,int j,String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return fun(0,s)-1;
    }
}