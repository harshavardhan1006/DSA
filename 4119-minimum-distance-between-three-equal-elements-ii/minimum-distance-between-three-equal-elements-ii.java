class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i] ,k -> new ArrayList<>()).add(i);
        }
        int res = Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(map.get(key).size() < 3) continue;
            List<Integer> list = map.get(key);
            for(int i=0;i<list.size()-2;i++){
                int diff = Math.abs(list.get(i)-list.get(i+1)) + Math.abs(list.get(i+1)-list.get(i+2)) + Math.abs(list.get(i+2)-list.get(i));
                res = Math.min(res,diff);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}