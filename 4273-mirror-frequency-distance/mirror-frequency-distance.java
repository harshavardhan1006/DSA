class Solution {
    public int mirrorFrequency(String s) {
        int[] alpha = new int[26];
        int[] num = new int[10];
        for(char ch:s.toCharArray()){
            if(ch >= 'a' && ch <= 'z') alpha[ch-'a']++;
            else if(ch >= '0' && ch <= '9') num[ch-'0']++;
        }
        int res = 0;
        boolean vis[] = new boolean[128];
        for(char ch:s.toCharArray()){
            if(vis[ch]) continue;
            if(ch >='a' && ch <= 'z'){
                res += Math.abs(alpha[ch-'a'] - alpha['z' - ch]);
                vis['a' + 'z' - ch] = true;
            }
            else if(ch >= '0' && ch <= '9'){
                res += Math.abs(num[ch-'0'] - num['9' - ch]);
                vis['0' + '9' - ch] = true;
            }
            vis[ch] = true;
        }
        return res;
    }
}