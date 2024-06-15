class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min PQ for projects (sorted by capital in ascending)
        PriorityQueue<int[]> minCapitals = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max PQ for profits
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a, b) -> b - a);

        // Populate minCapitals queue with projects
        for(int i = 0; i < profits.length; i++)
            minCapitals.add(new int[]{capital[i], profits[i]});

        // Iterate k times
        while (k-- > 0) {
            // Move all affordable projects to maxProfits queue
            while (!minCapitals.isEmpty() && w >= minCapitals.peek()[0])
                maxProfits.add(minCapitals.poll()[1]);

            // If no projects can be afforded, break the loop
            if (maxProfits.isEmpty()) break;

            // Select the most profitable project to increase capital
            w += maxProfits.poll();
        }
        return w;
    }
}
