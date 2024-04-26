/**
 * Definition for singly-linked list.
 */

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp = new ListNode();
    ListNode dummy = temp;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        temp.next = list1;
        list1 = list1.next;
      } else {
        temp.next = list2;
        list2 = list2.next;
      }
      temp = temp.next;
    }

    temp.next = list1 != null ? list1 : list2;
    return dummy.next;
  }
}