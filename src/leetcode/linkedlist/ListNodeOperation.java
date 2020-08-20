package leetcode.linkedlist;

public class ListNodeOperation {

	// ��ʼ������
	public static void initListNode(ListNode L) {
		L.setVal(1);
		L.setNext(null);
	}

	// ����������������ĳ���
	public static int traverse(ListNode L) {
		ListNode p = L;
		int count = 1;
		while (p.next != null) {
			p = p.next;
			count++;
		}
		return count;
	}

	// ������L��valת��ΪStringBuffer�����������Ϊ�ַ���
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

	// ������L��β������һ���ڵ㣬ֵΪval
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

	// ɾ����n���ڵ㣨��0��ʼ��
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

	// ��index=n��ʼ����������������str���򷵻�true���򷵻�false
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
