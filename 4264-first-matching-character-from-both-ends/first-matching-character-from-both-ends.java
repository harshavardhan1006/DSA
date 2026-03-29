class Solution {
    public int firstMatchingIndex(String s) {
        int i = 0;
        int n = s.length();
        while(i < (s.length()/2)+1){
            if(s.charAt(i) == s.charAt(n-i-1)) return i;
            i++;
        }
        return -1;
    }
}