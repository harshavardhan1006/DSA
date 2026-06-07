class Solution {
    public long maxTotal(int[] nums, String s) {
        long res = 0;
        int n = s.length();
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                res += nums[i];
                min = Math.min(nums[i],min);
            }else{
                if(i < n-1 && s.charAt(i+1) == '1'){
                    res += nums[i];
                    min = Math.min(nums[i],min);
                    res -= min;
                }
                min = Integer.MAX_VALUE;
            }
        }
        return res;
    }
}