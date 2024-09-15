class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode ans = new TreeNode(val);
            ans.left = root ; 
            return ans ;
        }
        solver(root,val,depth,1);
        return root ; 
    }
    public void solver(TreeNode root , int val , int depth , int i ) {
        if(root==null) return ;   
        if(depth-1==i){
            System.out.println(" level : " + i + " val : " + root.val ) ;
            if(root.left!=null){
                TreeNode left = root.left ; 
                root.left = new TreeNode(val);
                root.left.left = left ; 
            }else root.left = new TreeNode(val);
            if(root.right!=null){
                TreeNode right = root.right; 
                root.right = new TreeNode(val);
                root.right.right = right; 
            }else root.right = new TreeNode(val);  
        }else{
            solver(root.left,val,depth,i+1);
            solver(root.right,val,depth,i+1);
        }
        
    }
}
