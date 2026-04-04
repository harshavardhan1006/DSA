class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res1 = (long)need1*cost1 + (long)need2*cost2;

        long res2 = (long)costBoth*Math.max(need1,need2);

        long res3;
        long temp1 = (long)need2*costBoth;
        int rem = need1 - need2;
        if(rem <= 0) res3 = temp1;
        else res3 = temp1 + (long)rem*cost1;

        long res4;
        long temp2 = (long)need1*costBoth;
        rem = need2 - need1;
        if(rem <= 0) res4 = temp2;
        else res4 = temp2 + (long)rem*cost2;

        return Math.min(res1,Math.min(res2,Math.min(res3,res4)));
    }
}