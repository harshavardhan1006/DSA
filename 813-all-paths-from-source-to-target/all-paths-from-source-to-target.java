class Solution {
    private void dfs(int node,int target,List<Integer> li,List<List<Integer>> list,int[][] graph){
        if(node == target){
            li.add(target);
            list.add(new ArrayList(li));
            return;
        } 
        li.add(node); 
        for(int i:graph[node]){
            dfs(i,target,li,list,graph);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(0,graph.length-1,new ArrayList<>(),list,graph);
        return list;
    }
}