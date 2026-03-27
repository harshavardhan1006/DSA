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
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            if(map.get(node) == null) continue;
            for(int i:map.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        if(list.size() != numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++) res[i] = list.get(i);
        // System.out.println(map);
        return res;
    }
}