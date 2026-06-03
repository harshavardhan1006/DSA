class Solution {
    public int trap(int[] height) {
        int lmax=0;
        int rmax=0;
        int cap=0;
        int l=0,r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(lmax<height[l]){
                    lmax=height[l];
                }else{
                    cap+=lmax-height[l];
                }
                l++;
            }else{
                if(rmax<height[r]){
                    rmax=height[r];
                }else{
                    cap+=rmax-height[r];
                }
                r--;
            }
        }
        return cap;
    }
}