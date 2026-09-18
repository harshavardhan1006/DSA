class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[n];
        int[] prev = new int[n];
        int max = 1;
        int idx = 0;
        Arrays.fill(arr,1);
        for(int i=0;i<n;i++) prev[i] = i;
        for(int i=1;i<n;i++){
            int maxi = 1;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0){
                    if(maxi < 1+arr[j]){
                        maxi = 1+arr[j];
                        prev[i] = j;
                    }
                }
            }
            arr[i] = maxi;
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }
        // for(int i:arr) System.out.print(i+" ");
        //  System.out.println();
        // for(int i:prev) System.out.print(i+" ");
        while(idx != prev[idx]){
            res.add(nums[idx]);
            idx = prev[idx];
        }
        res.add(nums[idx]);
        return res;
    }
}