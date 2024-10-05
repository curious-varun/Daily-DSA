class Solution {
public:
    int dp[100][2][100];
    int solve(int i, bool turn, int m, vector<int>& piles) {
        int n=piles.size(), stones=0, ans = (turn) ? 0 : INT_MAX;;
        if(i >= n) {
            return 0;
        }
        if(dp[i][turn][m]!=-1) {
            return dp[i][turn][m];
        }
        for(int x=1; x<=min(2*m, n-i); x++) {
            stones+=piles[i+x-1];
            if(turn) {
                ans=max(ans, stones+solve(i+x, false, max(m, x), piles));
            }
            else {
                ans=min(ans, solve(i+x, true, max(m, x), piles));
            }
        }
        return dp[i][turn][m]=ans;
    }
    int stoneGameII(vector<int>& piles) {
        memset(dp, -1, sizeof(dp));
        // turn true is for Alice and turn false is for Bob
        return solve(0, true, 1, piles);
    }
};
