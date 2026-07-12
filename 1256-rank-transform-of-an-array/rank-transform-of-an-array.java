class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] sort = new int[n];
        for(int i=0;i<n;i++) sort[i] = arr[i];
        Arrays.sort(sort);
        int rank = 1;
        for(int i=0;i<n;i++){
            if(i > 0 && sort[i] > sort[i-1]) rank++;
            map.put(sort[i],rank);
        }
        int[] ranks = new int[n];
        for(int i=0;i<n;i++){
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }
}