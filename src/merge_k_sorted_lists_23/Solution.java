package merge_k_sorted_lists_23;

import java.sql.SQLOutput;
import java.util.Arrays;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    // Divide and conquer
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start)/2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;

        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                right = right.next;

            } else if (right == null) {
                current.next = left;
                left = left.next;

            } else if (left.val < right.val) {
                current.next = left;
                left = left.next;

            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            ListNode current = this.next;
            while (current != null) {
                sb.append("->").append(current.val);
                current = current.next;
            }
            sb.append("->").append("null");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().mergeKLists(new ListNode[] {
//                new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(1, new ListNode(3, new ListNode(4))),
//                new ListNode(2, new ListNode(6))
//        }));

        System.out.println(new Solution().mergeKLists(new ListNode[] {
                null,
                new ListNode(-1, new ListNode(5, new ListNode(11))),
                null,
                new ListNode(6, new ListNode(10))
        }));
    }
}