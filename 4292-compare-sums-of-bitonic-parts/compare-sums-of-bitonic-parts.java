class Solution {
    public int compareBitonicSums(int[] nums) {
        long sum = 0;
        int i = 0;
        int n = nums.length;
        while(i < n-1){
            if(nums[i] > nums[i+1]) break;
            sum += nums[i];
            i++;
        }
        i++;
        while(i < n){
            sum -= nums[i];
            i++;
        }
        if(sum == 0) return -1;
        return sum > 0 ? 0 : 1;
    }
}