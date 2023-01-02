/*
 * Video1 : https://www.youtube.com/watch?v=34WE6kwq49U
 * Video2 : https://www.youtube.com/watch?v=Q7v239y-Tik
 * 
 * Question:
    The cost of a stock on each day is given in an array, find the max profit that
     you can make by buying and selling in those days. For example, if the given
     array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earn 
     by buying on day 0, selling on day 3. Again, buy on day 4 and sell on day 6.
     If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
  
 * Algorithm: 
     Valley Peak Approach:
	    In this approach, we just need to find the next greater element and subtract
		it from the current element so that the difference keeps increasing until we 
	    reach a minimum. If the sequence is a decreasing sequence, so the maximum profit possible is 0.	 
 
 * Time Complexity: O(n)
   Auxiliary Space: O(1)
 */
package arrays;

public class StocksBuyAndSell {

	public static void main(String[] args) {
		int[] arr= { 100, 180, 260, 310, 40, 535, 695 };
		int n=arr.length;
		int maxProfit=0;
		int minSoFar=arr[0];
		int Mprofit=0;
		//here we can use the rain water trap method also, but space becomes O(n).
		//take array containing max elements and subtract it from main array.
		
		//This is for single time sell and buy
		for(int i=0;i<n;i++) {
			minSoFar=Math.min(minSoFar, arr[i]);
			int profit=arr[i]-minSoFar;
			maxProfit=Math.max(maxProfit, profit);
		}
		System.out.println("Max Profit: "+maxProfit);
		
		//For Multiple Buy And Sell
		for(int i=1;i<n;i++) {
			if(arr[i]>arr[i-1]) {
				Mprofit+=(arr[i]-arr[i-1]);
			}
		}
		System.out.println("Max Profit: "+Mprofit);
	}
}
