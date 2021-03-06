package com.varxyz.jv200.mod009;

import java.util.*;

public class GenericsWarning {
	public static void main(String[] args) {
//		Generic(제네릭)의 장점
//		1. 제네릭을 사용하면 잘못된 타입이 들어올 수 있는 것을 컴파일 단계에서 방지할 수 있다.
		
//		2. 클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다. 즉, 관리하기가 편하다.

//		3. 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.
		
		
//		List<Intger> list = new ArrayList<Integer>(); int로 사용시
//		list.add(0, new Integer(42));
//		int total = ((Integer)list.get(0)).intValue();
		
		List<String> list = new ArrayList<String>(); // generic code
				
		list.add(0, new String("string"));
		list.add("second");
		list.add("3rd");
		String str = ((String)list.get(0));
//		System.out.println(str);
		
		//for문으로 출력시
		
		for(String s:list) {
			System.out.println(s);
		}
		// 매우 간편하게 출력 가능하다.
		
//		for(int i=0; i<list.size(); i++) {
//			Object o = list.get(i);
//			System.out.println(o);
//		}
		
		// 위 방법은 예전 방식이다. 결과 값은 동일
	}
}
