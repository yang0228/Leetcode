public class buysellstock2{

	public static void main(String[] args){
		Solution s = new Solution();
		int[] stock = {1,1,4}; 
		int out = s.maxProfit(stock);
		System.out.println(out);
	}

}

class Solution {
	public int maxProfit(int[] prices) {

	/* right solution*/	
	 int total = 0;
     for (int i=0; i< prices.length-1; i++) {
         if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
     }

     return total;


	}
}