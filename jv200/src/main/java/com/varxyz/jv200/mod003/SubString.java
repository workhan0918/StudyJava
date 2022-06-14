package com.varxyz.jv200.mod003;

public class SubString {
	public static void main(String[] args) {
		String text = "The cat in the hat";
		System.out.println(isSubString("cat", text));
//		System.out.println(isSubStringContains("c", text));
	}
	
	public static boolean isSubString(String item, String line) {
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			for (int j = 0; j < item.length(); j++) {
				if( line.charAt(i) == item.charAt(j) ) {
					count ++;
				}
			}
		}
		System.out.println(count);
		if ( count == item.length()) {
			return true;
		}
		return false;

	}
	// 문자열 포함 여부 확인하는 메소드 string.contains()를 사용한 로직
//	public static boolean isSubStringContains(String item, String line) {
//		if (line.contains(item)) {
//			return true;
//		}
//		return false;
//	}
}
