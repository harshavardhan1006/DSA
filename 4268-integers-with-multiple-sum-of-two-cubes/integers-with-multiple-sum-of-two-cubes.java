class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<1000;i++){
            int temp = i*i*i;
            for(int j=i;j<=1000;j++){
                int t1 = j*j*j;
                if(temp + t1 > n) break;
                int sum = temp + t1;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i) >= 2) list.add((int)i);
        }
        Collections.sort(list);
        return list;
    }
}