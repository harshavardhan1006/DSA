class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i[]:edges){
            map.computeIfAbsent(i[0],k-> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],k-> new ArrayList<>()).add(i[0]);
        }
        int res = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i] && isComplete(i,map,vis)) res++;
        }
        return res;
    }
    private static boolean isComplete(int i,Map<Integer,List<Integer>> map,boolean[] vis){
        long edges = 0;
        long nodes = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int node = q.poll();
            if(vis[node]) continue;
            vis[node] = true;
            nodes++;
            List<Integer> list = map.get(node);
            if(list == null) continue;
            edges += list.size();
            for(int id:list){
                if(!vis[id]) q.add(id);
            }
        }
        edges /= 2;
        return edges == (long)nodes*(nodes-1)/2;
    }
}