package in.knowledgegate.dsa.linkedlist;

import in.knowledgegate.dsa.ListNode;

/**
 * Given the head of a singly linked list,
 * return true if it is a palindrome.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList checker =
            new PalindromeLinkedList();
        ListNode fourth = new ListNode(1);
        ListNode third = new ListNode(2, fourth);
        ListNode second = new ListNode(3, third);
        ListNode first = new ListNode(1, second);
        System.out.println("Palindrome status: "
        + checker.isPalindrome(first));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);
        while(head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
