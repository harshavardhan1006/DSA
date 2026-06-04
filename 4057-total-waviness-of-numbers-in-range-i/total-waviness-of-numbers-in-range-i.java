class Solution {
    public int totalWaviness(int num1, int num2) {
        int wave = 0;
        for(int i=num1;i<=num2;i++){
            wave += peakandvalley(i);
        }
        return wave;
    }
    private static int peakandvalley(int num){
        String s = String.valueOf(num);
        int i = 1;
        int count = 0;
        while(i < s.length()-1){
            char ch = s.charAt(i);
            if(ch > s.charAt(i-1) && ch > s.charAt(i+1)) count++;
            else if(ch < s.charAt(i-1) && ch < s.charAt(i+1)) count++;
            i++;
        }
        return count;
    }
}