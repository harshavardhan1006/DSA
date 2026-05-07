class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i = 0;
        int n = values.length;
        boolean[] vis = new boolean[n];
        while(i < n && i >= 0){
            if(vis[i]) break;
            vis[i] = true;
            if(instructions[i].equals("add")){
                score += values[i];
                i++;
            }else{
                i += values[i];
            }
        }
        return score;
    }
}