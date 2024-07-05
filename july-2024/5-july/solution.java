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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode first = head;
        ListNode temp = head.next;
        ListNode second = head.next.next;
        
        int [] ans = new int[2];
        List<Integer> store = new ArrayList<>();

        if(second == null){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        int count = 2;

        while(second != null){
            if(temp.val > first.val && temp.val > second.val){
                store.add(count);
            }
            if(temp.val < first.val && temp.val < second.val){
                store.add(count);
            }
            count++;
            temp = temp.next;
            first = first.next;
            second = second.next;                
        }

        if (store.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int fc = store.get(0);
        int lc = store.get(store.size() -1 ); 

        for(int i = 1 ; i < store.size(); i++){
            // System.out.println(store.get(i));
            min = Math.min(min, store.get(i) - store.get(i-1));
        }

        max = lc - fc;

        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
            ans[0] = -1;
            ans[1] = -1;
        }else{
            ans[0] = min;
            ans[1] = max;                        
        }

        return ans;
    }
}
