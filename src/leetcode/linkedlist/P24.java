package leetcode.linkedlist;

/**
 * @Description: Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes
 * @Author: LiuLang
 * @Date: 2021/6/3 19:03
 */
public class P24 {

    /**
     * 给定 1->2->3->4->5, 返回 2->1->4->3->5.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head==null) {
            return null;
        }
        // 表头节点，默认链表中的数据都为正数
        ListNode preHead = new ListNode(-1);
        preHead.next=head;

        ListNode left=preHead;
        ListNode mid=head;
        // 如果只有一个节点，直接返回这个节点
        if(head.next==null)
        {
            return head;
        }
        ListNode right=head.next;

        while(mid!=null && mid.next!=null){
            //交换节点的过程
            mid.next=right.next;
            right.next=mid;
            left.next=right;

            //移动节点的过程
            left=mid;
            mid=left.next;

            //注意细节：首先要保证mid不为null，才能将mid.next赋值给right
            if(mid!=null)
            {
                right=mid.next;
            }
        }
        return preHead.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }
}
