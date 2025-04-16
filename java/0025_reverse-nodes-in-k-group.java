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
        int cnt = 0;
        for(ListNode curr = head; curr != null; curr = curr.next) {
            cnt++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pt0 = dummy;
        while (cnt >= k) {
            cnt = cnt - k;
            ListNode pre = null;
            ListNode curr = pt0.next;
            for(int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            ListNode nxt = pt0.next;
            pt0.next.next = curr;
            pt0.next = pre;
            pt0 = nxt;
        }
        return dummy.next;
    }
}