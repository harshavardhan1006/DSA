class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[graph.length];
        for(int i=0;i<graph.length;i++) list.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                list.get(j).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        // for(int i:inDegree) System.out.print(i+" ");
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            // inDegree[node]--;
            for(int i:list.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0) queue.add(i);
            }
        }
        // System.out.println(list);
        Collections.sort(res);
        return res;
    }
}