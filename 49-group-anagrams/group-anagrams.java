class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String t = new String(ch);
            map.computeIfAbsent(t , k -> new ArrayList<>()).add(s);
        }
        for(String s:map.keySet()){
            list.add(map.get(s));
        }
        return list;
    }
}