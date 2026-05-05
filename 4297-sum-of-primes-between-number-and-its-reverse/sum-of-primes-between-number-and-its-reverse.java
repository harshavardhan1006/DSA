class Solution {
    static int[] prime = new int[1002];
    static{
        for(int i=2;i<1002;i++) prime[i] = 1;
        for(int i=2;i*i<=1002;i++){
            if(prime[i] == 1){
                for(int j=i*i;j<1002;j+=i){
                    prime[j] = 0;
                }
            }
        }
    }
    private int reverse(int n){
        int num = 0;
        while(n > 0){
            int rem = n%10;
            num = num*10 + rem;
            n /= 10;
        }
        return num;
    }
    public int sumOfPrimesInRange(int n) {
        int r = reverse(n);
        int sum = 0;
        for(int i=Math.min(n,r);i<=Math.max(n,r);i++){
            if(prime[i] == 1) sum += i;
        }
        return sum;
    }
}