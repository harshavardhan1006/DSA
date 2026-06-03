class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int k = count(nums,0);
        int k1 = k+ count(nums,1);
        int k2 = k1 + count(nums,2);
        for(int x=0;x<k;x++){
            nums[x] = 0;
        }
        for(int x=k;x<k1;x++) nums[x] = 1;
        for(int x=k1;x<k2;x++) nums[x] = 2;
    }
    public static int count(int[] nums,int i){
        int c = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] == i){
                c++;
            }
        }
        return c;
    }
}