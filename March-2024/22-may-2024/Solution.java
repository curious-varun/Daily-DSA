class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ll = new ArrayList<>();
        solver(s, ans, ll, 0);
        return ans;
    }

    public void solver(String s, List<List<String>> ans, List<String> ll, int id) {
        if (id > s.length()) return;
        if (id == s.length()) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        for (int i = id; i < s.length(); i++) {
            if (isPalindrome(s, id, i)) {
                ll.add(s.substring(id, i + 1));
                solver(s, ans, ll, i + 1);
                ll.remove(ll.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

