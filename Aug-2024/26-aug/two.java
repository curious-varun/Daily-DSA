class Solution {
    public int search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    public int find(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        if (nums[start] > nums[end]) return Math.max(find(nums, target, start, mid - 1), find(nums, target, mid + 1, end));
        else {
            if (nums[mid] > target) return find(nums, target, start, mid - 1);
            else return find(nums, target, mid + 1, end);
        }
    }
}

