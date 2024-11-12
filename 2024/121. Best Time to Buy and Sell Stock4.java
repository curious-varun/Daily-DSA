class Solution {
    public int maxProfit(int[] nums) {
        int profit = Integer.MIN_VALUE ; 
        int op = nums[0] ; //original price 
        //int sp = nums[0] ; // selling price 
        for ( int i =0 ; i < nums.length ; i++ ){
            if ( nums[i] < op ){
                op = nums[i] ; 
                continue ; 
            }
            int curr = nums[i] - op ; // the current profit 
            profit = Math.max(profit , curr  ) ; // the overall profit 

        }
        return profit ; 
    }
}
