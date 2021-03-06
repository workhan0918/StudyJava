package com.varxyz.jv200.mod003;

public class ArrayCopyExercise {

	public static void main(String[] args) {
		
		int[] nums = new int[] { 1, 2, 3, 4, 5 }; 
		int[] target = new int[] { 1, 3, 5, 7 };
		
		System.out.println(arrayJudge(nums, target));
	}
	
	public static String arrayJudge(int[] nums, int[] target) {
		String result = null;
		int count = 0;
		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ( target[i] == nums[j] ) {
					count ++;
				}
			}
		}
		if (count == target.length) {
			result = "완벽히 일치";
		}else if ( count > 0 & count < nums.length | count > nums.length ) {
			result = "일부만 포함";
		}else if ( count == 0 ) {
			result = "아무것도 일치하지않음";
		}
		return result;
	}
}
