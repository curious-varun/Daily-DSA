class Solution {
    public int minMovesToSeat(int[] seats, int[] nums ) {
        Arrays.sort(seats); Arrays.sort(nums);
        int ans = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            ans += Math.abs(seats[i] - nums[i]) ;

        }
        return ans ;
    }
}
