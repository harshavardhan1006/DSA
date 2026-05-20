class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;
        long tmax = Long.MIN_VALUE;
        for(int i:nums){
            if(i > max){
                tmax = smax;
                smax = max;
                max = (long)i;
            }else if(i != max && i > smax){
                tmax = smax;
                smax = (long)i;
            }else if(i != max && i != smax && i > tmax) tmax = (long)i;
        }
        // System.out.println(max+" "+smax+" "+tmax);
        return tmax != Long.MIN_VALUE  ? (int)tmax : (int)max;
    }
}