class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0 ; 
        for(int num : nums ){
            if(map.containsKey(target-num)){
                return new int[]{i,map.get(target-num)};
            }
                map.put(num,i++);
        }
        return new int[]{0,0};
    }
}

