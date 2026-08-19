class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] i:reservedSeats){
            map.computeIfAbsent(i[0],k->new HashSet<>()).add(i[1]);
        }
        long res = n*2;
        for(int i:map.keySet()){
            Set<Integer> set = map.get(i);
            boolean t1 = !(set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5));
            boolean t2 = !(set.contains(4) || set.contains(5) || set.contains(6) || set.contains(7));
            boolean t3 = !(set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9));
            res -= 2;
            if(t1 && t2 && t3) res += 2;
            else if(t1 || t2 || t3) res += 1;
        }
        return (int)res;
    }
}