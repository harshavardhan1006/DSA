class Solution {
    public List<String> partitionString(String s) {
        Set<String> res = new HashSet<>();
        List<String> res1 = new ArrayList<>();
        String st = "";
        int i = 0;
        while(i < s.length()){
            String ch = st + s.charAt(i);
            if(!res.contains(ch)){
                res.add(ch);
                res1.add(ch);
                st = "";
            }
            else{
                st = ch;   
            }
            i++;
        }
        return res1;
    }
}