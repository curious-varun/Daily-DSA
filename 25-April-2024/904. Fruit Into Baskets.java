class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer,Integer> map  = new HashMap<>(); 
        int len = nums.length ;
        int end = 0 ; int start = 0 ; 
        int ans = 0 ; 


        while(end<len){
            map.put(nums[end], map.getOrDefault(nums[end],0)+1);
            while(map.size()>2){
                System.out.println(" num : " + nums[end] + " size " + map.size() ) ; 
                map.put(nums[start], map.getOrDefault(nums[start],0)-1);
                if(map.get(nums[start]) <= 0 ) map.remove(nums[start]) ; 
                start ++ ; 
            }
            ans = Math.max(ans , end - start + 1) ; 
            end ++; 

        }

        return ans ;
    }
}
