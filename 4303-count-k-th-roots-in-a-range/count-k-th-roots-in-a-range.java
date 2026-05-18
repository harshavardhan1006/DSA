class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1) return r-l+1;
        int total = 0;
        int nrml = 0;
        for(int i=0;Math.pow(i,k)<=r;i++){
            int temp = (int)Math.pow(i,k);
            if(temp < l) nrml++;
            if(temp <= r) total++;
            else if(temp > r) break;
        }
        return total-nrml;
    }
}