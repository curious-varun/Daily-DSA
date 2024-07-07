class Solution {
    public int numWaterBottles(int nums, int exchange) {
        int totalBottles = nums;

        while (nums >= exchange) {
            int newBottles = nums / exchange;
            int remaining = nums % exchange;
            totalBottles += newBottles;
            nums = newBottles + remaining;
        }

        return totalBottles;
    }
}
