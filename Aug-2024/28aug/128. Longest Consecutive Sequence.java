class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>(); 
        int ans = 0 ; int curr = 0 ; 
        for(int num : nums) st.add(num);
        for(int i = 0 ; i < nums.length ; i ++ ) {
            if(!st.contains(nums[i]-1)){
                curr = 0 ; int num = nums[i] ; 
                while(st.contains(num++)) curr ++ ; 
            }
            ans = Math.max(curr,ans);
        }
        return ans ;
    }
}
