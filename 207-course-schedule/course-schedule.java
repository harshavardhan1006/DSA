class Solution {
    boolean detect(int node,boolean[] vis,boolean[] path,List<List<Integer>> li){
        vis[node] = true;
        path[node] = true;
        for(int i:li.get(node)){
            if(!vis[i]){
                if(detect(i,vis,path,li)) return true;
            }
            else if(path[i]) return true;
        }
        path[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0;i<V;i++) li.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            li.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(detect(i,vis,path,li)) return false;
            }
        }
        return true;
    }
}