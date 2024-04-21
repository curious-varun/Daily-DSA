import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int count = 0;
        int start = 0;
        int end = 0;

        while (end < len) {
            // Expand the window
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            end++;

            // Check if the window contains all three characters
            while (map.size() == 3) {
                // Update the count based on the current window size
                count += len - end + 1;
                
                // Shrink the window
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0)
                    map.remove(s.charAt(start));
                start++;
            }
        }

        return count;
    }
}

