package com.varxyz.jv200.mod009;

import java.util.*;

public class SetExample {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second");
		set.add(new Integer(4));
		System.out.println(set);
		// 결과값: [5.0, 4, 3rd, one, second]
		// add한 순서대로 들어가지않으며 중복값이 허용되지 않는다.
	}
}
