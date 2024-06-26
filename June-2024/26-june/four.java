class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder() ; 
        solver(root,sb);
        return sb.toString() ; 
    }
    public void solver(TreeNode root , StringBuilder sb){
        if(root==null) return ; 
        sb.append(root.val);
        if(root.left!=null){
            sb.append("(");
            solver(root.left,sb);
            sb.append(")");
        }
        if(root.left==null && root.right!=null) sb.append("()");
        if(root.right!=null){
            sb.append("(");
            solver(root.right,sb);
            sb.append(")");
        }
    }
    
}
