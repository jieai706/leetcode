package leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
			}
		};
		list.add(list1);
		List<Integer> list2 = new ArrayList<>(list1);
		System.out.println(list2.size());
	}
}
