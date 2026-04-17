class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(reverse(nums[0]),0);
        for(int i=1;i<nums.length;i++){
            int t = nums[i];
            if(hm.containsKey(t)){
                res = Math.min(res,i-hm.get(t));
            }
            hm.put(reverse(t),i);
        }
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
    public static int reverse(int s){
        int n = s;
        int rev = 0;
        while(n != 0){
            int d = n % 10;
            rev = rev * 10 + d;
            n /= 10;
        }
        return rev;
    }
}