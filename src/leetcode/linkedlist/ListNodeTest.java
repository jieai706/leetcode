package leetcode.linkedlist;

public class ListNodeTest {

	public static void main(String[] args) {
		ListNode L = new ListNode();
		System.out.println("��ʼ����");
		ListNodeOperation.initListNode(L);
		System.out.println(L.toString());
		 
		System.out.println("����ڵ㣺");
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,0);
		ListNodeOperation.insertListNode(L,0);
		ListNodeOperation.insertListNode(L,1);
		ListNodeOperation.insertListNode(L,0);
		System.out.println(L.toString());
		 
		int count = ListNodeOperation.traverse(L);
		System.out.println("�ڵ������"+count);
		 
		StringBuffer str = ListNodeOperation.outputListNode(L);
		System.out.println(str);
		//���һ��L��λ��
		int lastindex = ListNodeOperation.lastIndex(L,0);
		System.out.println("���һ��L��λ�ã�"+lastindex);
		 
		System.out.println("ɾ��һ���ڵ�");
		ListNodeOperation.deleteListNode(L,2);
		 
		count = ListNodeOperation.traverse(L);
		System.out.println("�ڵ������"+count);
		str = ListNodeOperation.outputListNode(L);
		System.out.println(str);
		System.out.println(L.toString());
	}
}
