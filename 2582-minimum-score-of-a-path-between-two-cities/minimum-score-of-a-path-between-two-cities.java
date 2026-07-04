class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int[] i:roads){
            list.get(i[0]).add(new int[]{i[1],i[2]});
            list.get(i[1]).add(new int[]{i[0],i[2]});
        }
        int min = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int node = q.poll();
            if(set.contains(node)) continue;
            set.add(node);
            for(int[] i:list.get(node)){
                q.add(i[0]);
                min = Math.min(i[1],min);
            }
        }
        return min;
    }
}