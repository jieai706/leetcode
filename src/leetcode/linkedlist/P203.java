package leetcode.linkedlist;

/**
 * Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * @author jieai706
 * @date 2020-08-21
 */
public class P203 {

	// ����������Ľ��ͨ��Ҫ����һ����������һ����ͷ����������ָ�����һ�������������ϵ�������ʱ��ɾ����
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
