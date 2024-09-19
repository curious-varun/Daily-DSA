class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        int start = 0; int end = nums.length - 1; int min = nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2; // or (end + start)/2 
            if (nums[mid] > min) { // skip the left part
                min = Math.min(nums[mid], min);
                start = mid + 1;
            } else { // skip the right part
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }
        }
        return min;
    }
}

