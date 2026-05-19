class Solution {
    class Pair{
        int node;
        int steps;
        Pair(int node,int steps){
            this.node = node;
            this.steps = steps;
        }
    }
    Map<Integer,List<Integer>> map = new HashMap<>();
    public int minJumps(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k -> new ArrayList<>()).add(i);
        }
        int sum = 0;
        boolean[] vis = new boolean[n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int node = p.node;
            int steps = p.steps;
            if(node == n-1) return steps;
            if(node < 0 || node >= n || vis[node]) continue;
            vis[node] = true;
            queue.add(new Pair(node+1,steps+1));
            queue.add(new Pair(node-1,steps+1));
            if(!map.containsKey(arr[node])) continue;
            for(int i1:map.get(arr[node])){
                queue.add(new Pair(i1,steps+1));
            }
            map.remove(arr[node]);
        }
        return 0;
    }
}