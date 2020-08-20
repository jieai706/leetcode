package leetcode.linkedlist;

public class ListNodeTest {

	public static void main(String[] args) {
		ListNode L = new ListNode();
		System.out.println("初始化：");
		ListNodeOperation.initListNode(L);
		System.out.println(L.toString());
		 
		System.out.println("插入节点：");
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,0);
		ListNodeOperation.insertListNode(L,0);
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,0);
		System.out.println(L.toString());
		 
		int count = ListNodeOperation.traverse(L);
		System.out.println("节点个数："+count);
		 
		StringBuffer str = ListNodeOperation.outputListNode(L);
		System.out.println(str);
		//最后一个L的位置
		int lastindex = ListNodeOperation.lastIndex(L,0);
		System.out.println("最后一个L的位置："+lastindex);
		 
		System.out.println("删除一个节点");
		ListNodeOperation.deleteListNode(L,2);
		 
		count = ListNodeOperation.traverse(L);
		System.out.println("节点个数："+count);
		str = ListNodeOperation.outputListNode(L);
		System.out.println(str);
		System.out.println(L.toString());
	}
}
