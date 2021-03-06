package com.varxyz.jv200.mod009;

import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("second");
		list.add("3rd");
		list.add(new Integer(4));
		list.add(new Float(5.0F));
		list.add("second");
		list.add(new Integer(4));
		System.out.println(list);
		// 결과값 : [one, second, 3rd, 4, 5.0, second, 4]
		// list는 순서,중복값을 허용한다.
	}
}
