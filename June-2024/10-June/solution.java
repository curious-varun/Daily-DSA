class Solution {
    public int heightChecker(int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int height : heights) pq.add(height);

        int res = 0;
        for(int height : heights) {
            if(height != pq.poll()) res++;
        }


        return res;
    }
}
