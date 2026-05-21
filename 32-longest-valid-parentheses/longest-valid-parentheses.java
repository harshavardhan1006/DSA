class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxValid = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                if(!st.isEmpty() && s.charAt(st.peek()) == '(') st.pop();
                else{
                    st.push(i);
                }
            }
        }
        int temp = s.length();
        // if(st.isEmpty()) return s.length();
        // System.out.println(st);
        while(!st.isEmpty()){
            maxValid = Math.max(maxValid,temp-st.peek()-1);
            temp = st.pop();
        }
        maxValid = Math.max(maxValid,temp-0);
        return maxValid;
    }
}