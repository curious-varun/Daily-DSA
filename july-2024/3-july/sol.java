class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if (len <= 4) return 0;  

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            int curr = nums[len - 1 - (3 - i)] - nums[i];
            min = Math.min(min, curr);
        }
        
        return min;
    }
}

/* 
class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if(len<=4) return 0 ; 
        Arrays.sort(nums);
        return solver(nums, 0, len - 1,3);
    }
    

    public int solver(int[] nums, int start, int end, int count ) {

        if (count < 0 || start >= end) return Integer.MAX_VALUE;
        int my = nums[end] - nums[start];
        
        int left = nums[start + 1] - nums[start];
        int right = nums[end] - nums[end - 1];
        
        if (left > right) return Math.min(my, solver(nums, start + 1, end,count-1));
        else if (right > left) return Math.min(my, solver(nums, start, end - 1,count-1));
        else return Math.min(my, Math.min(solver(nums, start + 1, end,count-1), solver(nums, start, end - 1,count-1)));
    }


*/ 

