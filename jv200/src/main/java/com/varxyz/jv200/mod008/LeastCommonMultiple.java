package com.varxyz.jv200.mod008;

public class LeastCommonMultiple {
	public int commonMultiple(int num) {
		int tempNum = num;
		int quotient;
		for (int i = 2; i < num; i++) {
			if(tempNum % i == 0) {
				quotient = i;
//				System.out.println(tempNum+"을");
				tempNum = tempNum / quotient;
//				System.out.println(quotient+"로 나눔");
//				System.out.println("나누고 남은 값:"+tempNum+"\n");
				i = 1;
				if(tempNum > 1) {
					System.err.print(quotient + "X");					
				}
				if(tempNum == 1) {
					System.err.println(quotient+"="+num+" 로 최대공배수를 구할 수 있기 때문에");
				}
			}
		}
		return num;
	}
}
