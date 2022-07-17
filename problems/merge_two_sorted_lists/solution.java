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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //l1 should always be smaller than l2, if it is not then swap.
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        while(l1 != null && l2 != null){
            ListNode tmp = null;
            while(l1 != null && l1.val <= l2.val){
                tmp = l1; //stores last smaller  l1 value which will be finally pointing to l2(greateer value) 
                l1 = l1.next;
            }
            tmp.next = l2; //break bond for pointing to greater value for correct order
            
            //re-initialize l1 to smaller value and l2 to greater value
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        return res;
    }
}