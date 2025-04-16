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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pt0 = dummy;
        for(int i = 0; i < left - 1; i++) {
            pt0 = pt0.next;
        }
        ListNode pre = null;
        ListNode curr = pt0.next;
        for(int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        pt0.next.next = curr;
        pt0.next = pre;
        return dummy.next;
    }
}