class Solution {
    static int count;
    private static void fun(int idx,int[] nums,int target){
        if(idx == nums.length){
            if(target == 0) count++;
            return;
        }
        fun(idx+1,nums,target-nums[idx]);
        fun(idx+1,nums,target+nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        fun(0,nums,target);
        return count;
    }
}