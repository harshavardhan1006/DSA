class Solution {
    public long sumAndMultiply(int n) {
        long res = 0;
        int sum = 0;
        int pos = 1;
        while(n > 0){
            int rem = n%10;
            if(rem != 0){
                res += rem * pos;
                pos *= 10;
            }
            sum += rem;
            n /= 10;
        }
        return (long)res*sum;
    }
}