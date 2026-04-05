class Solution {
public:
    bool judgeCircle(string moves) {
        int up = 0;
        int l = 0;
        for(int i=0;i<moves.size();i++){
            char ch = moves[i];
            if(ch == 'U') up++;
            else if(ch == 'L')  l++;
            else if(ch == 'D') up--;
            else l--;
        }
        return up == 0 && l == 0;
    }
};