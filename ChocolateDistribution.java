/*
 * link : https://leetcode.com/problems/candy/
 * Video:https://www.youtube.com/watch?v=PzBYQA6FshA
 * 
 * Question: There are n children standing in a line. Each child is assigned a 
    rating value given in the integer array ratings.
	You are giving candies to these children subjected to the following requirements:
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	
	Example 1:
	
	Input: ratings = [1,0,2]
	Output: 5
	Explanation: 
	 You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
	 
 *Complexity Analysis:
	Time Complexity: O(N).Only one traversal of the array is needed, So time Complexity is O(N).
	Space Complexity: O(N).Two extra arrays are needed, each of size N.		 
 */
package arrays;

public class ChocolateDistribution {

	public static void main(String[] args) {
		int[] arr= {1,0,2};
		int n=arr.length;
		int ans=0;
		int[] right = new int[n]; //33344455
		int[] left = new int[n]; //55555552
		
		for(int i=1;i<n;i++){
			left[0]=1;
			if(arr[i]>arr[i-1]) {
				left[i]=left[i-1]+1;
			}
			else {
				left[i]=1;
			}
		}
		
		for(int i=n-2;i>=0;i--){
			right[n-1]=1;
			if(arr[i]>arr[i+1]) {
				right[i]=right[i+1]+1;
			}
			else {
			right[i]=1;
			}
		}
		
		for(int i=0;i<n;i++) {
			ans+=(Math.max(left[i], right[i]));
		}
		System.out.println("Total no. of candies are: "+ans);

	}

}
