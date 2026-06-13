class Solution {
    private static int dfs(int node,int parent,Map<Integer,List<Integer>> map){
        int depth = 0;
        for(int i:map.get(node)){
            if(i == parent) continue;
            depth = Math.max(depth , dfs(i,node,map) + 1);
        }
        return depth;
    }
    public int assignEdgeWeights(int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i:edges){
            map.computeIfAbsent(i[0] , k-> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1] , k-> new ArrayList<>()).add(i[0]);
        }
        int maxDepth = dfs(1,0,map);
        int ans = 1;
        for(int i=1;i<maxDepth;i++){
            ans *= 2;
            ans %= 1000000007;
        }
        return ans;
    }
}