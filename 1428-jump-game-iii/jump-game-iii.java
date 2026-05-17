class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return dfs(start,vis,arr);
    }
    private boolean dfs(int i,boolean[] vis,int[] arr){
        if(i < 0 || i >= arr.length || vis[i]) return false;
        if(arr[i] == 0) return true;
        vis[i] = true;
        return dfs(i-arr[i],vis,arr) || dfs(i+arr[i],vis,arr);
    }
}