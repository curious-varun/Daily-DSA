class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0; // Initialize max to 0
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i); // Update i to the next position after the repeating character
            }
            map.put(ch, j);
            max = Math.max(max, j - i + 1); // Update max for every valid substring
            j++;
        }
        return max;
    }
}

