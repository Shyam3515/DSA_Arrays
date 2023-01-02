/*
 * Link : https://www.geeksforgeeks.org/trapping-rain-water/
 * Video : https://www.youtube.com/watch?v=UZG3-vZlFM4
 * Question : Given an array of N non-negative integers arr[] representing an elevation 
     map where the width of each bar is 1, compute how much water it is able to trap after raining.
     
     Input: arr[] = {2, 0, 2}
	Output: 2
	Explanation: The structure is like below.
	We can trap 2 units of water in the middle gap.
	
 * Algorithm:
   *Follow the steps mentioned below to implement the approach:

	1.Create two arrays left[] and right[] of size N. Create a variable (say max)
	  to store the maximum found till a certain index during traversal.
	2.Run one loop from start to end: 
	3.In each iteration update max and also assign left[i] = max.
	4.Run another loop from end to start: 
	5.In each iteration update max found till now and also assign right[i] = max.
	6.Traverse the array from start to end.
	7.The amount of water that will be stored in this column is min(left[i], right[i]) – array[i]
	8.Add this value to the total amount of water stored
	9.Print the total amount of water stored.
	
 * Complexity Analysis:
	Time Complexity: O(N).Only one traversal of the array is needed, So time Complexity is O(N).
	Space Complexity: O(N).Two extra arrays are needed, each of size N.		
 */
package arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] arr= {3,1,2,4,0,2,5,2};
		int n=arr.length;
		int left=arr[0];
		int right=arr[n-1];
		int ans=0;
		int[] max = new int[n]; //33344455
		int[] min = new int[n]; //55555552
		
		for(int i=0;i<n;i++){
			if(arr[i]>left) {
				left=arr[i];
			}
			max[i]=left;
		}
		
		for(int i=n-1;i>=0;i--){
			if(arr[i]>right) {
				right=arr[i];
			}
			min[i]=right;
		}
		
		//Printing Left Max Array
		System.out.print("Max: ");
		for(int i=0;i<n;i++) {
			System.out.print(max[i]);
		}
		System.out.println();
		//Printing Right Max Array
		System.out.print("Min: ");
		for(int i=0;i<n;i++) {
			System.out.print(min[i]);
		}
		
		//Formula To find Trapped Water
		for(int i=0;i<n;i++) {
			ans+=(Math.min(min[i], max[i])-arr[i]);
		}
		System.out.println();
		System.out.println("Rain Units Trapped are: "+ans);

	}

}
