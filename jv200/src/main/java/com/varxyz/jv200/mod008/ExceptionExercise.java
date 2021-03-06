package com.varxyz.jv200.mod008;

public class ExceptionExercise {
	public static int primeNumber(int num) throws MyException,PrimeException {		
		if( num <= 0 ) {
			System.out.println("입력한 숫자: "+num);
			throw new MyException();
		}
		
		int count = 0;
		if (num == 1 || num == 3) {
			System.out.println(num + "은(는) 소수입니다.");
		}else {
			for (int i = 2; i <= num; i++) {
				for (int j = 2; j <= num; j++) {
					if( i % j == 0) {
						count++;
					}
				}
				if (count > 1) {
					count = 0;
				}
			}
			if(count == 1) {
				System.out.println(num + "은(는) 소수입니다.");
			}else {
				System.err.println("입력한 숫자: "+num);
				LeastCommonMultiple l = new LeastCommonMultiple();
				l.commonMultiple(num);
				throw new PrimeException();
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		try {
			primeNumber(511);
		} catch (MyException e) {
			e.printStackTrace();
		} catch (PrimeException e) {
			e.printStackTrace();
		}
	}
}
