/*
 *
 *Given an array of integers, every element appears twice except for one. Find that single one.
 *Note:
 *Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

public class SingleNumber {

	public static void main(String[] args){
		System.out.println(0 ^ 6);
		System.out.println(2 ^ 2);
		System.out.println(0 ^ 0);
		System.out.println(3 ^ 4);
		System.out.println(1 ^ 1);
		int[] test = {2,3,1,3,2};
		int output = singleNumber(test);
		System.out.println("output is:" + output);
		System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
		//int max = 2147483648; integer too large
		//System.out.println("max:" + max);
	}



		    
		    public static int singleNumber(int[] A) {
			            
			            int xor = 0;
				            for(int i = 0; i < A.length; i++){
						                xor = xor ^ A[i];
								            
								        }
					            
					            return xor;
						        }
	

}
