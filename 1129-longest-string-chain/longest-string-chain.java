class Solution {
    int[][] dp;
    int fun(int i,String[] words,int prev){
        if(i == words.length) return 0;
        if(prev != - 1 && dp[i][prev] != -1) return dp[i][prev];
        int pick = 0;
        if(prev == -1){
            pick = 1+fun(i+1,words,i);
        }else if(isPossible(words[prev],words[i])){
            pick = 1+fun(i+1,words,i);
        }
        int notpick = fun(i+1,words,prev);
        if(prev != -1) return dp[i][prev] = Math.max(pick,notpick);
        return Math.max(pick,notpick);
    }
    boolean isPossible(String s1,String s2){
        if(s1.length()+1 != s2.length()) return false;
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == s1.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new int[n][n];
        for(int[] i:dp) Arrays.fill(i,-1);
        Arrays.sort(words,(a,b)->a.length()-b.length());
        return fun(0,words,-1);
    }
}