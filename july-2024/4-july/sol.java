/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans ; 
        ListNode i = head ;
        boolean flag = false ; 
        int sum = 0 ; 
        while(i!=null){
            if(i.val==0){
                if(flag){
                    ListNode curr = new ListNode(sum);
                    temp.next = curr ; 
                    temp = temp.next ;
                    sum = 0 ; 

                }
                else flag = true ; 
            }
            sum += i.val ; 
            i = i.next ;

        } 
                    
        return ans.next ;
    }
}
