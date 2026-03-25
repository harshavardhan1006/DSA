class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = 0;
        int even = 0;
        int sodd = Integer.MAX_VALUE;
        int seven = Integer.MAX_VALUE;
        // Set<Integer> set = new HashSet<>();
        for(int i:nums1){
            if((i & 1) == 1){
                odd++;
                sodd = Math.min(sodd,i);
            }
            else{
                even++;
                seven = Math.min(seven,i);
            }
            // set.add(i);
        }
        if(odd == 0 || even == 0) return true;

        // odd check
        boolean bool = false;
        for(int i:nums1){
            if((i & 1) == 0){
               int temp = i - sodd;
               if(temp < 1){
                bool = true;
                break;
               }
            }
        }
        if(bool == false) return true;

        // even check
        bool = false;
        for(int i:nums1){
            if((i & 1) == 1){
                // System.out.println(i);
                int temp = i - sodd;
                if(temp < 1){
                    bool = true;
                    break;
                }
            }
        }
        if(bool == false) return true;
        return false;
    }
}