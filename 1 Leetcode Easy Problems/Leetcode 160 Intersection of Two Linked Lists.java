/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == headB)
      return headA;
    if (headA == null || headB == null)
      return null;

    ListNode first = headA;
    ListNode second = headB;
    while (first != second) {
      first = first != null ? first.next : headB;
      second = second != null ? second.next : headA;
    }
    return first;
  }
}
