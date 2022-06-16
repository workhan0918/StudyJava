package com.varxyz.jv200.mod007;

/**
 * 
 * interface
 * -. abstract(추상화) 메소드의 집합, 상수 (public)
 * -. 인스턴스 생성불가
 * -. 다중상속 지원
 * @author Administrator
 *
 */

public interface Flyer {
	public void fly(); // abstract 생략
	public void takeOff();
	public void land();
}
