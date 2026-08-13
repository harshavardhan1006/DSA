class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(-1,new ArrayList<>(List.of(0)));
        int n = nums.length;
        for(int i=1;i<n;i++){
            int par = parent[i];
            if(map.containsKey(par)){
                map.get(par).add(i);
            }else{
                map.put(par,new ArrayList<>(List.of(i)));
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,1});
        int height = 0;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int depth = q.peek()[1];
            q.poll();
            height = Math.max(depth,height);
            if(!map.containsKey(node)) continue;
            for(int i:map.get(node)){
                q.add(new int[]{i,depth+1});
            }
        }
        long res = 0;
        q.add(new int[]{0,1});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int depth = q.peek()[1];
            q.poll();
            res += (long)nums[node]*(height-depth+1);
            if(!map.containsKey(node)) continue;
            for(int i:map.get(node)){
                q.add(new int[]{i,depth+1});
            }
        }
        return res;
    }
}