class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            map.computeIfAbsent(prerequisites[i][1],k-> new ArrayList<>()).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        int idx = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            res[idx++] = node;
            if(map.get(node) == null) continue;
            for(int i:map.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        if(count != numCourses) return new int[]{};
        return res;
    }
}