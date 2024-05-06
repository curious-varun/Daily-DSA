class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode it = head ; 
        while(it!=null){
            if(st.isEmpty()){
                st.push(it);
                it=it.next;
                continue ;
            }
            while(!st.isEmpty() && st.peek().val < it.val) st.pop();
            st.push(it);
            it=it.next ;
        }


        ListNode ans = null ; 
        ListNode temp = null ; 


        while(!st.isEmpty()){
                temp = ans ; 
                ans = st.pop() ; 
                ans.next = temp ; 
        } 

        return ans; 

    }
}
