class Solution {
    private static int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return Math.abs(a);
    }
    public int findGCD(int[] nums) {
        int small = 1001;
        int large = 0;
        for(int i:nums){
            small = Math.min(small,i);
            large = Math.max(large,i);
        }
        return gcd(small,large);
    }
}