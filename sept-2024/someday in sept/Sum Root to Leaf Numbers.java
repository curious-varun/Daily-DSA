class Solution {
    public int sumNumbers(TreeNode root) {
        return solver(root, 0);
    }

    public int solver(TreeNode root, int n) {
        if (root == null) {
            return 0; // Return 0 when the current node is null
        }
        // Calculate the sum for the left and right subtrees
        int sum = solver(root.left, ((n * 10) + root.val)) + solver(root.right, ((n * 10) + root.val));
        // If it's a leaf node, add the current number to the sum
        if (root.left == null && root.right == null) {
            sum += ((n * 10) + root.val);
        }
        return sum;
    }
}

