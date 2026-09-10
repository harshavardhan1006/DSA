class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        if(n == 2) return nums[0] != nums[1] ? 1 : 0;
        int i = 0;
        long sum = 0;
        int res = 0;
        while(i < n/2) sum += nums[i++];
        while(i < n) sum -= nums[i++];
        if(sum > 0) res++;
        int j = n/2;
        int k = n/2-1;
        while(j < n+k){
            sum += (long)(nums[j%n]+nums[j%n]);
            sum -= (long)(nums[i%n]+nums[i%n]);
            if(sum > 0) res++;
            i++;
            j++;
        }
        return res;
    }
}