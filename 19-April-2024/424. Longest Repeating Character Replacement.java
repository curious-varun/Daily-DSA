class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int[] count = new int[26];
        int maxCount = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int window = i - j + 1;
            maxCount = Math.max(maxCount, ++count[c - 'A']);
            int replacement = window - maxCount;
            if (replacement > k) {
                count[s.charAt(j) - 'A']--;
                j++;
            } else {
                max = Math.max(max, window);
            }
        }

        return max;
    }
}

