class Solution {
    public boolean canAliceWin(int[] nums) {
       int one = 0 ; int two = 0 ; int sum = 0 ;  
       for(int num : nums){
            if(num>=10) two+= num ;
            else one += num ;
            sum += num ;
       } 
       return (sum-one)<one || (sum-two)<two ; 
    }
}
