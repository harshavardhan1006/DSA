class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1 = 0;
        int zero2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i:nums1){
            if(i == 0) {
                zero1++;
                sum1 += 1;
            }
            sum1 += i;
        }
        for(int i:nums2){
            if(i == 0) {
                zero2++;
                sum2 += 1;
            }
            sum2 += i;
        }
        if(sum1 > sum2){
            if(zero2 == 0) return -1;
        }
        if(sum1 < sum2){
            if(zero1 == 0) return -1;
        }
        if(sum1 > sum2) return sum1;
        return sum2;
    }
}