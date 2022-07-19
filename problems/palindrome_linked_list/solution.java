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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = revLL(slow.next);
        
        slow = slow.next;
        
        while(slow != null){
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    ListNode revLL(ListNode head){
        ListNode tmpHead = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = tmpHead;
            tmpHead = head;
            head = next;
        }
        return tmpHead;
    }
}