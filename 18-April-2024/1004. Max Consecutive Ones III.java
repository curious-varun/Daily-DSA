class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0 ; int end = 0 ; 
        int zeros = 0 ; int ans = 0 ; 
        int len = nums.length ;
        if(k>len) return len ;
        while(end<len){
            if(nums[end]==0)zeros++ ; 
            while(zeros>k){
                if(nums[start++] == 0 ) zeros -- ; 
            }
            ans = Math.max(ans , (end++ -start+1)) ; 
        }
        return ans ; 

    }
}
