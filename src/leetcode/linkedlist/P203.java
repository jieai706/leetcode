package leetcode.linkedlist;

/**
 * Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * @author jieai706
 * @date 2020-08-21
 */
public class P203 {

	// 链表类问题的解决通常要复刻一个链表，建立一个空头。再用两个指针遍历一遍链表，遇到符合的链表结点时则删除它
	public ListNode removeElements(ListNode head, int val) {
		ListNode result = new ListNode();
		result.next=head;
		ListNode fast = head, slow = result;
		while (fast != null) {
			if (fast.val == val) {
				slow.next = fast.next;
			} else {
				slow = slow.next;
			}
			fast = fast.next;
		}
		return result.next;
    }
}
