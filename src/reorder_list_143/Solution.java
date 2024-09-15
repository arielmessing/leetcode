package reorder_list_143;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head,
            fast = head,
            prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        merge(head, reverse(slow));
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null,
            current = head,
            next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private void merge(ListNode head1, ListNode head2) {

        while (head1 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            if (next1 == null) break;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}