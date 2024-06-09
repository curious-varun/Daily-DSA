class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with remainder 0 having one count

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            // Adjust remainder to be non-negative
            if (remainder < 0) {
                remainder += k;
            }
            if (map.containsKey(remainder)) {
                count += map.get(remainder);  // Add the count of subarrays found so far
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;  
    }
}
