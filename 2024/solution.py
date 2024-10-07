class Solution(object):
    def beautifulSubsets(self, A: List[int], k: int) -> int:
        count = Counter(A)

        def dp(a):
            dp0, dp1 = dp(a - k) if a - k in count else (1, 0)
            return dp0 + dp1, dp0 * (pow(2, count[a]) - 1)

        return reduce(mul, (sum(dp(a)) for a in count if not count[a + k])) - 1
