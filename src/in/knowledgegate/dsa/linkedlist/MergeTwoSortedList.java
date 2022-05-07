package in.knowledgegate.dsa.linkedlist;

/**
 * You are given the heads of two sorted linked
 * lists list1 and list2.
 *
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [dummy, 1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * The number of nodes in both lists is in the
 * range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in
 * non-decreasing order.
 */
public class MergeTwoSortedList {
  private class ListNode {
    int val;
    ListNode next;
  }

  public ListNode mergeTwoLists(ListNode list1,
                                ListNode list2) {
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

