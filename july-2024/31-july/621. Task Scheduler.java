class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        solver(nums, 0, new ArrayList<>());
        return ans;
    }
    
    public void solver(int[] nums, int i, List<Integer> ll) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        
        // Include the current element
        ll.add(nums[i]);
        solver(nums, i + 1, ll);
        
        // Exclude the current element
        ll.remove(ll.size() - 1);
        solver(nums, i + 1, ll);
    }
}
