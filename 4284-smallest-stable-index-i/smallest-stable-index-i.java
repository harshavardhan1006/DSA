class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        int i1 = 1;
        int j = n-2;
        max[0] = nums[0];
        min[n-1] = nums[n-1];
        while(i1 < n){
            max[i1] = Math.max(nums[i1],max[i1-1]);
            min[j] = Math.min(nums[j],min[j+1]);
            i1++;j--;
        }
        for(int i=0;i<n;i++){
            if(max[i]- min[i] <= k) return i;
        }
        
        return -1;
    }
}