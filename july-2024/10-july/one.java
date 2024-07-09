class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currTime = 0; 
        double totalWaitTime = 0; 
        
        for (int i = 0; i < customers.length; i++) {
            if (currTime < customers[i][0]) {
                currTime = customers[i][0] + customers[i][1];
            } else {
                currTime += customers[i][1];
            }
            totalWaitTime += (currTime - customers[i][0]);
        }
        
        return (double) totalWaitTime / customers.length;
    }
}
