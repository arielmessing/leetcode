package reverse_linked_list_ii_92;

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

        ListNode prev = null,
            current = head;

        while (left > 1) {
            prev = current;
            current = current.next;

            left--;
            right--;
        }

        ListNode tailOfPrefix = prev,
            tailOfReversed = current;

        while (right > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            right--;
        }

        if (tailOfPrefix != null) {
            tailOfPrefix.next = prev;
        
        } else {
            head = prev;
        }

        tailOfReversed.next = current;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}