package com.varxyz.jv200.mod003;

public class multipliCationTable {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "X" + i + "=" + i*j+"\t");					
			}
			System.out.println();
		}
	}
}
