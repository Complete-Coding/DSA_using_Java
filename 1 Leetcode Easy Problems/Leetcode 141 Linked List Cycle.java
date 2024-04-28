/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode first = head;
    ListNode second = first.next;
    while (second != null && first != null) {
      if (first == second) {
        return true;
      }
      second = second.next != null ? second.next.next : null;
      first = first.next;
    }
    return false;
  }
}





