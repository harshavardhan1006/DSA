class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int valid = 0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                left++;
            }else{
                if(left == 0){
                    valid++;
                    continue;
                }
                left--;
            }
        }
        if(left > 0) valid += left;
        return valid;
    }
}