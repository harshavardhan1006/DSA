class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int operations = 0;
        for(auto i:nums){
            if(i < k) operations++;
        }
        return operations;
    }
};