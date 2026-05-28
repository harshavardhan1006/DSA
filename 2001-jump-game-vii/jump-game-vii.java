class Solution {
    public boolean canReach(String s, int minJump, int maxJump){
        if(s.charAt(s.length()-1) == '1') return false;
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.add(0);
        int lastIndex = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            int min = Math.max(i + minJump,lastIndex+1);
            int max = Math.min(i+maxJump,n-1);
            if(min > n-1) continue;
            for(int j=min;j<=max;j++){
                if(j >= n || vis[j] || s.charAt(j) == '1') continue;
                if(j == n-1) return true;
                if(s.charAt(j) == '0'){
                    q.add(j);
                    vis[j] = true;
                }
            }
            lastIndex = Math.max(lastIndex,max);
        }
        return false;
    }
}