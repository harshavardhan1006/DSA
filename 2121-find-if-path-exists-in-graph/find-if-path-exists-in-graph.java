class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> list = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            list.computeIfAbsent(edges[i][0],k -> new ArrayList<>()).add(edges[i][1]);
            list.computeIfAbsent(edges[i][1],k -> new ArrayList<>()).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;
            for(int i:list.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }
}