class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length ; map.put(0,1);
        int ans = 0 ; int count = 0 ;
        for(int i = 0 ; i < len ; i++ ) { 
            if(nums[i]%2!=0) count ++ ; 
            map.put(count, map.getOrDefault(count,0)+1) ;  
            if(map.containsKey(count-k)){
                ans+= map.get(count-k);
            } 
        }
        return ans ;
        
    }
}
