/*
 * Link : https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
 * Video : https://www.youtube.com/watch?v=nGLiMx5mLYY
 * Question : Given an array, reverse every sub-array formed by consecutive k elements.

	Examples: 
	Input: 
	 arr = [1, 2, 3, 4, 5, 6, 7, 8, 9] 
	 k = 3 
	Output: 
	 [3, 2, 1, 6, 5, 4, 9, 8, 7]
	 
 * Approach: Consider every sub-array of size k starting from the beginning of the array and reverse it.
    	We need to handle some special cases. If k is not multiple of n where n is the size of the array, 
   		for the last group we will have less than k elements left, we need to reverse all remaining elements.
    	If k = 1, the array should remain unchanged. If k >= n, we reverse all elements present in the array.
  
 * Time complexity of above solution is O(n). 
   Auxiliary space used by the program is O(1).	
 */
package arrays;

public class ReverseArrayInGroups {

	public static void main(String[] args) {
		int arr[] = {15,16,9,8,3,2,6,1,4};
		int n=arr.length;
		int k=3;
		
		for(int i=0;i<n;i=i+k) {
			int left=i;
			//while i=n-1,i+k-1 is out of bounds, to make sure it works till last
			//we are taking 'minimum',so, right=min(10,8).
			//Here, 8 is length of array && 10 is the last iteration.
			
			//i+k-1=2,left =0;right=2.That is 0-->2.
			int right=Math.min(i+k-1, n-1);
			
			while(left<right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		System.out.println("Reverse Array is: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
