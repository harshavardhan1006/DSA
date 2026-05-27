class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq = new int[26];
        Set<Character> set = new HashSet<>();
        for(char ch:word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                freq[ch-'a']++;
                set.add(ch);
            }
        }
        int res = 0;
        for(char ch:word.toCharArray()){
            if(ch >= 'a' && ch <= 'z') freq[ch-'a']--;
            else if(ch >= 'A' && ch <= 'Z'){
                char ch1 = Character.toLowerCase(ch);
                if(freq[ch1 - 'a'] == 0 && set.contains(ch1)){
                    set.remove(ch1);
                    res++;
                }else if(freq[ch1-'a'] != 0) set.remove(ch1);
            }
        }
        return res;
    }
}