package partition_list_86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHeadDummy = new ListNode();
        ListNode greaterHeadDummy = new ListNode();
        ListNode current = head;
        ListNode lessPrev = lessHeadDummy;
        ListNode greaterPrev = greaterHeadDummy;

        while (current != null) {
            var next = current.next;

            if (current.val < x) {
                lessPrev.next = current;
                lessPrev = lessPrev.next;
            
            } else {
                greaterPrev.next = current;
                greaterPrev = greaterPrev.next;
            }

            current = next;
        }

        greaterPrev.next = null;
        lessPrev.next = greaterHeadDummy.next;

        return lessHeadDummy.next;
    }

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}