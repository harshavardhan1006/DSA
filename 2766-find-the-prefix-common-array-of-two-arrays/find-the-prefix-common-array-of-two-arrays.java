class Solution {
    public int[] findThePrefixCommonArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] prefix = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if(nums1[0] == nums2[0]) prefix[0] = 1;
        else prefix[0] = 0;
        set1.add(nums1[0]);set2.add(nums2[0]);
        for(int i=1;i<nums1.length;i++){
            set1.add(nums1[i]);
            set2.add(nums2[i]);
            if(nums1[i] == nums2[i]) prefix[i] = prefix[i-1] + 1;
            else{
                int count = 0;
                for(int i1:set1){
                    if(set2.contains(i1)){
                        count ++;
                    }
                }
                prefix[i] = count;
            }
        }
        return prefix;
    }
}