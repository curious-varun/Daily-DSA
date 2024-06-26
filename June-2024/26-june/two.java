class Solution {
    public TreeNode balanceBST(TreeNode root) {
       if(root==null) return root ;
       ArrayList<Integer> ll = new ArrayList<>();
       getList(ll,root) ; 
       return solver(ll , 0 , ll.size()-1); 
    }
    public void getList(ArrayList<Integer> ll , TreeNode root ){ 
        if(root==null) return ; 
        getList(ll,root.left) ; 
        ll.add(root.val) ;  
        getList(ll,root.right) ; 
    }

    public TreeNode solver(ArrayList<Integer> ll , int start , int end){
        if(start>end) return null ; 

        int mid = start +(( end - start )/2);  
        TreeNode root = new TreeNode(ll.get(mid)) ; 
        root.left= solver(ll,start,mid-1) ; 
        root.right = solver(ll,mid+1,end) ; 

        return root ;
    }

}
