package leetcode.linkedlist;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new sorted list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author jieai706
 * @date 2020-08-20
 */
public class P21 {
	
	/**
	 * 这道又是关于链表的题目，拿到链表的题目，就要想到dummy大法好。
	 * 由于题目要求我们不能开辟一个新的空间来存储链表，所以我们需要在l1和l2的基础上进行排序。具体步骤如下：
	 * 设置好了dummy之后，我们设置一个节点，令node指向dummy，即node = dummy；
	 * 然后对l1和l2中的每个节点进行遍历：
	 * 如果l1中的节点值大于l2中的节点值，那么这个节点的值就为l2当前所指节点的值，并且node和l2都要指向next；
	 * 如果l1中的节点值小于l2中的节点值，那么这个节点的值就为l1当前所指节点的值，并且node和l1都要指向next；
	 * 最后不能忘记的就是边界问题
	 * 如果链表l1比链表l2长，那么很可能会出现l2已经遍历完了，而l1还有剩余的情况。由于l1是有序链表，所以只需要将剩下的l1中的节点全加到node后面去即可；
	 * 反之亦然。
	 * 还有不能忘记的是l1和l2为空的问题：
	 * 如果l1和l2均为空链表，直接返回null；
	 * 如果l1和l2其中一个为空，则直接返回另一个链表即可，这样有利于减少计算量。
	 * 方法说明
	 * @param l1
	 * @param l2
	 * @return ListNode
	 * @author jieai706
	 * @date 2020-08-20
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode node = result;
		
		if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1 == null && l2 == null) {
            return null;
        }
		
		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				node.next = l2;
				node = l2;
				l2 = l2.next;
			} else {
				node.next = l1;
				node = l1;
				l1 = l1.next;
			}
		}
		if (l1 != null) {
			node.next = l1;
		}
		if (l2 != null) {
			node.next = l2;
		}
		return result.next;
    }
	

//if(l1 == null) return l2;
//if(l2 == null) return l1;
//if(l1.val < l2.val){
//l1.next = mergeTwoLists(l1.next, l2);
//return l1;
//} else{
//l2.next = mergeTwoLists(l1, l2.next);
//return l2;
//}
}
