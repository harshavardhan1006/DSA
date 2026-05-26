class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        int special = 0;
        for(char ch:word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                if(!set.contains(ch) && set.contains(Character.toUpperCase(ch))) special++;
            }else{
                if(!set.contains(ch) && set.contains(Character.toLowerCase(ch))) special++;
            }
            set.add(ch);
        }
        return special;
    }
}