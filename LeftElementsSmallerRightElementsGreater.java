/*
 * Link : https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 * Video : https://www.youtube.com/watch?v=_QsA70cqzG0
 * question : Given an array, find an element before which all elements are smaller 
	 than it, and after which all are greater than it. Return the index 
  	 of the element if there is such an element, otherwise, return -1.
  	 
 * Algorithm: 
    1)Create two arrays leftMax[] and rightMin[].
	2)Traverse input array from left to right and fill leftMax[] such that 
	  leftMax[i] contains a maximum element from 0 to i-1 in the input array.
	3)Traverse input array from right to left and fill rightMin[] such that 
	  rightMin[i] contains a minimum element from to n-1 to i+1 in the input array.
	4)Check if element in max[i] is equal to min[i], if equals print element.
	
 * Time Complexity/Space Complexity
    O(n)/O(n)		 
 */
package arrays;

public class LeftElementsSmallerRightElementsGreater {

	public static void main(String[] args) {
		int[] arr={4,3,2,7,8,9};
		int n=arr.length;
		int big=arr[0];
		int small=arr[n-1];
		int flag=0;
		int[] max = new int[n]; //4,4,4,7,8,9
		int[] min = new int[n]; //2,2,2,7,8,9
		
		for(int i=0;i<n;i++){
			if(arr[i]>big) {
				big=arr[i];
			}
			max[i]=big;
		}
		
		for(int i=n-1;i>=0;i--){
			if(arr[i]<small) {
				small=arr[i];
			}
			min[i]=small;
		}
		
		for(int i=0;i<n;i++){
			//we do not check for extreme values, since the required element
			//doesn't lie in extreme values
			if(i!=0 && i!=n-1) {
				if(max[i]==min[i]) {
					flag=1;
					System.out.println("Element is: "+max[i]+","+"Index is: "+i);
					break;
				}
			}
		}
		
		System.out.print("Max: ");
		for(int i=0;i<n;i++) {
			System.out.print(max[i]);
		}
		System.out.println();
		System.out.print("Min: ");
		for(int i=0;i<n;i++) {
			System.out.print(min[i]);
		}
		if(flag==0) {
			System.out.println("Element not found...");
		}
	}

}
