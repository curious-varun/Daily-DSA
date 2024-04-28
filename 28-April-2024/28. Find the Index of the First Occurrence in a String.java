class Solution {
    public int strStr(String one, String two) {
        int l1 = one.length();
        if (l2 > l1)
            return -1;
        int j = 0;
        for (int i = 0; i <= l1 - l2; i++) {
            int k = i;
            while (j < l2 && one.charAt(k) == two.charAt(j)) {
                k++;
                j++;
            }
            if (j == l2)
                return i;
            else
                j = 0;
        }
        return -1;
    }
}

