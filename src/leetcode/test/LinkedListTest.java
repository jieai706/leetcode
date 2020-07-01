package leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		LinkedList<String> list2 = new LinkedList<>(list);
		list2.addFirst("c");
		System.out.println(list2.getLast());
	}
}
