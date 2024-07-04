class Solution {
    int count ; 
    public int goodNodes(TreeNode root) {
        count = 0 ; 
        solver(root,Integer.MIN_VALUE) ;  
        return count ;
    }
    public void solver(TreeNode root , int max){
        if(root == null) return ; 
        if(root.val>=max) count ++ ; 
        solver(root.left,Math.max(root.val,max));
        solver(root.right,Math.max(root.val,max));
    }
}
