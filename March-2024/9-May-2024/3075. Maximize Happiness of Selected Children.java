class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) pq.offer(num);
        long ans = 0; int i = 0;
        while (!pq.isEmpty() && pq.peek() - i > 0 && k-->0) {
            ans += pq.poll() - i++;
        }
        return ans;
    }
}

