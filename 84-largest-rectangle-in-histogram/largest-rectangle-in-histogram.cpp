class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> next(heights.size());
        vector<int> prev(heights.size());
        stack<int> st1;
        stack<int> st2;
        int n = heights.size();
        for(int i=heights.size()-1;i>=0;i--){
            while(!st1.empty() && heights[i]  <= heights[st1.top()]) st1.pop();
            next[i] = st1.empty() ? n : st1.top();
            st1.push(i);
        }
        for(int i=0;i<heights.size();i++){
            while(!st2.empty() && heights[i] <= heights[st2.top()]) st2.pop();
            prev[i] = st2.empty() ? -1 : st2.top();
            st2.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++) {
            int h = heights[i];
            int w = next[i]-prev[i]-1;
            res = max(res,h*w);
        }
        return res;
    }
};