class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int ans = Integer.MIN_VALUE ; 
        for(int num : nums ) if(num <0) st.add(num) ; 
        for(int num : nums ) if(num > 0 && st.contains(num * -1)) ans = Math.max(num , ans ) ;
        return ans == Integer.MIN_VALUE  ? -1 : ans ;
        
    }
}
