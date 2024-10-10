class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        n = len(nums)
        stack = []
        res = 0

        for i in range(n):
            if stack == [] or nums[i] < nums[stack[-1]]:
                stack.append(i)
        
        for i in range(n - 1, -1, -1):
            while(stack and nums[i] >= nums[stack[-1]]):
                res = max(res, i - stack.pop())

        return res
