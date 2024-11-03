class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        
        // Check if the lengths are different, then it cannot be a rotation.
        if (len != goal.length()) return false;
        
        // Iterate through each character in `s` to check for potential rotations.
        for (int i = 0; i < len; i++) {
            // If the characters match, check if it is a rotation by using helper method.
            if (s.charAt(i) == goal.charAt(0) && helper(i, s, goal)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(int startIdx, String s, String goal) {
        int len = s.length();

        for (int i = 0; i < len; i++) {
            // Calculate the rotated index in `s`
            int idx = (startIdx + i) % len;

            // Compare characters; if any do not match, it is not a rotation.
            if (s.charAt(idx) != goal.charAt(i)) return false;
        }
        return true;
    }
}

