class Solution {
private:
    int helper(int i, long long v, int t, vector<int> &nums, vector<vector<int>> &dp) {
        
        if (i == nums.size()) return (v == t) ? 1 : 0;
        if (dp[i][v] != -1) return dp[i][v];

      
        int pick = helper(i + 1, v | nums[i], t, nums, dp);
        int np = helper(i + 1, v, t, nums, dp);

        return dp[i][v] = pick + np;
    }

public:
    int countMaxOrSubsets(vector<int>& nums) {
        int n = nums.size();
        long long max_or = 0;

        for (int num : nums) {
            max_or |= num;
        }

        vector<vector<int>> dp(n, vector<int>(max_or + 1, -1));

        return helper(0, 0, max_or, nums, dp);
    }
};
