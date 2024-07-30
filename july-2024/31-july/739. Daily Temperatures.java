import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        int[] ans = new int[len];
        
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if (st.isEmpty()) ans[i] = 0;
            else ans[i] = st.peek() - i;
            st.push(i);
        }

        return ans;
    }
}
