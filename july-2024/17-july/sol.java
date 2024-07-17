class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] del) {
        List<TreeNode> ll = new ArrayList<>();
        HashSet<Integer> st = new HashSet<>();
        for(int num : del ) st.add(num) ; 
        if(st.contains(root.val)) ll.add(root); 

        solver(root,st,ll);

        return ll ; 
    }
    public void solver(TreeNode root , HashSet<Integer> st , List<TreeNode> ll ){
        if(root==null) return ; 
        solver(root.right,st,ll);
        solver(root.left,st,ll);
        if(st.contains(root.val)){
            if(root.left!=null) ll.add(root.left);
            if(root.right!=null) ll.add(root.right);
        }

        solver(root.left,st,ll);

    } 
}
