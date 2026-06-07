class Solution {
    private static void fun(int idx,List<String> list,String s,int n,int k){
        if(idx == n-1){
            int i = 0;
            int sum = 0;
            while(i < s.length()){
                if(s.charAt(i) == '1') sum += i;
                i++;
            }
            if(sum <= k) list.add(s);
            return;
        }
        fun(idx+1,list,s+'0',n,k);
        if(s.length() > 0 && s.charAt(s.length()-1) == '0'){
            fun(idx+1,list,s+'1',n,k);
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();
        fun(0,list,"0",n,k);
        fun(0,list,"1",n,k);
        return list;
    }
}