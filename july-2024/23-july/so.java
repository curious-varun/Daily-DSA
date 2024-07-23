class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,INteger> map = new HashMap<>();
        for(int num : nums ) map.put(num , map.getOrDefault(num,0)+1);
        int[][] arr  = new int[map.size()][map.size()] ; 
        int i = 0 ; 


        for(int num : map.keySet()){
            arr[i][1] = num ; 
            arr[i][0] = map.get(num); 
            i++ ; 
        } 

        nums = new int[nums.length] ; 

        









        return nums ;
        
    }
}
