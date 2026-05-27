class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(nums[0],0);
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res = 0;
        for(int i:map.keySet()){
            if((map.containsKey(i+k) && k > 0) || (k == 0 && map.get(i) > 1)) res++;
        }
        return res;
    }
}