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
	 * ������ǹ����������Ŀ���õ��������Ŀ����Ҫ�뵽dummy�󷨺á�
	 * ������ĿҪ�����ǲ��ܿ���һ���µĿռ����洢��������������Ҫ��l1��l2�Ļ����Ͻ������򡣾��岽�����£�
	 * ���ú���dummy֮����������һ���ڵ㣬��nodeָ��dummy����node = dummy��
	 * Ȼ���l1��l2�е�ÿ���ڵ���б�����
	 * ���l1�еĽڵ�ֵ����l2�еĽڵ�ֵ����ô����ڵ��ֵ��Ϊl2��ǰ��ָ�ڵ��ֵ������node��l2��Ҫָ��next��
	 * ���l1�еĽڵ�ֵС��l2�еĽڵ�ֵ����ô����ڵ��ֵ��Ϊl1��ǰ��ָ�ڵ��ֵ������node��l1��Ҫָ��next��
	 * ��������ǵľ��Ǳ߽�����
	 * �������l1������l2������ô�ܿ��ܻ����l2�Ѿ��������ˣ���l1����ʣ������������l1��������������ֻ��Ҫ��ʣ�µ�l1�еĽڵ�ȫ�ӵ�node����ȥ���ɣ�
	 * ��֮��Ȼ��
	 * ���в������ǵ���l1��l2Ϊ�յ����⣺
	 * ���l1��l2��Ϊ������ֱ�ӷ���null��
	 * ���l1��l2����һ��Ϊ�գ���ֱ�ӷ�����һ�������ɣ����������ڼ��ټ�������
	 * ����˵��
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
