package com.varxyz.jv200.mod003;

public class PrimeNumber {
	public static void main(String[] args) {
		int count = 0;
		int realCount = 0;
		for (int i = 2; i <= 1000; i++) {
			for (int j = 2; j <= 1000; j++) {
				if( i % j == 0) {
					count++;
				}
			}
			if(count == 1) {
				realCount ++;
				System.out.println(i + " ");
			}
			count = 0;
		}
		System.out.println(realCount);		
	}
}
