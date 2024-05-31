class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int row = findRow(nums, target); 
        if (row < 0) return false; 
        int start = 0; int end = nums[row].length - 1; 
        while (start <= end) {  
            int mid = start + ((end - start) / 2);  
            if (nums[row][mid] == target) return true; 
            else if (nums[row][mid] < target) start = mid + 1; 
            else end = mid - 1; 
        }
        return false;
    }

    public int findRow(int[][] nums, int target) {
        int start = 0;
        int end = nums.length - 1; 
        while (start <= end) {  
            int mid = start + ((end - start) / 2);  
            int s = nums[mid][0]; 
            int e = nums[mid][nums[mid].length - 1];  
            if (target >= s && target <= e) return mid;  
            else if (target > e) start = mid + 1; 
            else end = mid - 1; 
        }
        return -1; 
    }
}
