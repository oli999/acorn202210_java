package test.main;

public class MainClass07 {
	public static void main(String[] args) {
		int[] nums= {10, 20, 30, 40, 50};
		
		for(int i=0; i<nums.length; i++) {
			int tmp=nums[i];
			System.out.println(tmp);
		}
		
		System.out.println("----- 확장 for 문을 사용하면 -----");
		
		for(int tmp:nums) {
			System.out.println(tmp);
		}
	}
}
