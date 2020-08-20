package leetcode.linkedlist;

public class ListNodeOperation {

	// 初始化链表
	public static void initListNode(ListNode L) {
		L.setVal(1);
		L.setNext(null);
	}

	// 遍历链表，返回链表的长度
	public static int traverse(ListNode L) {
		ListNode p = L;
		int count = 1;
		while (p.next != null) {
			p = p.next;
			count++;
		}
		return count;
	}

	// 把链表L的val转化为StringBuffer输出，输出结果为字符串
	public static StringBuffer outputListNode(ListNode L) {
		StringBuffer str = new StringBuffer("");
		ListNode p = L;
		for (@SuppressWarnings("unused")
		int i = 0;;) {
			str.append(p.val);
			if (p.next != null) {
				p = p.next;
			} else {
				break;
			}
		}
		return str;
	}

	// 在链表L的尾部插入一个节点，值为val
	public static void insertListNode(ListNode L, int val) {
		ListNode p = L;
		ListNode q = new ListNode();
		for (@SuppressWarnings("unused")
		int i = 0;;) {
			if (p.next == null) {
				q.setVal(val);
				q.setNext(null);
				p.setNext(q);
				System.out.println("Insert " + val + " success.");
				break;
			} else {
				p = p.next;
			}
		}
	}

	// 删除第n个节点（从0开始）
	public static void deleteListNode(ListNode L, int n) {
		int count = 1;
		ListNode p = L;
		for (@SuppressWarnings("unused")
		int i;;) {
			if (count == n) {
				p.setNext(p.next.next);
				break;
			} else {
				count++;
				p = p.next;
			}
//			if (count == n) {
//				L.setNext(L.next.next);
//				break;
//			} else {
//				count++;
//				L = L.next;
//			}
		}
	}

	// 从index=n开始遍历，如果后面出现str，则返回true否则返回false
	public static int lastIndex(ListNode L, int str) {
		ListNode p = L;
		int flag = 0;
		for (int i = 0; i < traverse(L); i++) {
			if (p.val == str) {
				// System.out.println(i);
				flag = i;
			}
			p = p.next;
		}
		return flag;
	}
}
