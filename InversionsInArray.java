/*
 * Link : https://www.geeksforgeeks.org/counting-inversions/
 * Question:Inversion Count for an array indicates – how far (or close) the array 
  		is from being sorted. If the array is already sorted, then the inversion count 
  		is 0, but if the array is sorted in the reverse order, the inversion count is the maximum. 

	Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j	
	Example: 
	Input: arr[] = {8, 4, 2, 1}
	Output: 6
	Explanation: Given array has six inversions:
	(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
 * 
 *  Time Complexity/Space Complexity:
    O(nlogn)/O(1) 
    nlogn- Because as we decrease the value of i, j iterates next from i.
 */
package arrays;

public class InversionsInArray {

	public static void main(String[] args) {
		int[] arr= {8, 4, 2, 1,6,9,5,7};
		int n=arr.length;
		int c=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					System.out.print("("+arr[i]+","+arr[j]+")"+" ");
					c++;
				}
			}
		}
		System.out.println();
		System.out.println("Number of inversions are: "+c);
	}

}
