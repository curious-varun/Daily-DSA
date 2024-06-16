class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int npatches = 0;
        for (int num : nums) {
            if (num > n) {
                break;
            }
            while (sum < num - 1) {
                sum += sum + 1;
                ++npatches;
            }
            sum += num;
        }
        while (sum < n) {
            sum += sum + 1;
            ++npatches;
        }
        return npatches;
    }
}
