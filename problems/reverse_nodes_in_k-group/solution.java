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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        
        ListNode pre = temp, nex = temp, cur = temp;
        
        int count = 0;
        while(cur.next != null){
            cur = cur.next;
            count++;
        }
        
        while(count >= k){
            cur = pre.next;
            nex = cur.next;
            for(int i = 1; i < k; i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            count -= k;
            pre = cur;
        }
        return temp.next;
    }
}