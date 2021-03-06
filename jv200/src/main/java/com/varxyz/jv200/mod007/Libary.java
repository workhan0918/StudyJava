package com.varxyz.jv200.mod007;

public class Libary {
	private static int leng = 100;
	private static Book[] bookArray = new Book[leng];
	
	private static void Libary() {}
	
	// 사용자로부터 시리얼번호를 받아 책정보를 출력해주는 메소드
	public static void getBook(int serial) {
		for (int i = 0; i < bookArray.length; i++) {
			if( bookArray[i] == null) {
				System.err.println("오류 : 잘못 된 시리얼 번호를 입력하셨습니다.");
				break;
			} else if (serial == bookArray[i].getSerial()) {
				System.out.println("Book Name : " + bookArray[i].getName() + 
						"\nBook Serial : " + bookArray[i].getSerial() + "\n--------------------\n");
				break;
			}
		}
	}
	// Libary bookArray에 Book객체를 넣어주는 메소드
	public static void addBook(Book book) {
		// bookArray 배열에 값이 할당되지 않았을때는 default값으로 null값이 할당된다.
		for (int i = 0; i < bookArray.length; i++) {
			if (bookArray[i] == null) {
				bookArray[i] = book;
				break;
			//bookArray에 공간이 꽉차면 2배로 공간을 늘려준다.
			}else if(bookArray[i] != null) {
				leng = leng*2;
			}
		}
	}
}
