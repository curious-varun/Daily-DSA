class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length ; int ans = 0 ; 
        int max = -1  ; int min = prices[0]; 
        for(int i = 1 ; i < len ; i++ ) {
            int curr = prices[i] ; 
            if(curr<min){
                max = 0 ; 
                min = curr ; 
            }
            else{
                max = Math.max(max,curr);
            }
            ans = Math.max(ans , (max-min));
        }


        return ans ; 
    }
}
