/*
 * Link: https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 * krishna teachers:
 * Video: https://www.youtube.com/watch?v=HD2epovyPic&list=PLvI381EFf-Uio-3KkcLtYoe7GaIaxSb6f&index=4
 * Question: You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 *  There are no duplicates in the list. One of the integers is missing in the list. 
 *  Write an efficient code to find the missing integer.
  
 *  Example: 
	Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
	Output: 5
	Explanation: The missing number from 1 to 8 is 5
	
	Input: arr[] = {1, 2, 3, 5}
	Output: 4
	Explanation: The missing number from 1 to 5 is 4
	
 *Algorithm:
	 *Method 1: This method uses the technique of the summation formula.
	 *Approach:
		The length of the array is n-1. So the sum of all n elements, i.e sum of numbers from 1 to n can be calculated using the formula n*(n+1)/2. Now find the sum of all the elements in the array and subtract it from the sum of first n natural numbers, it will be the value of the missing element.
		
		Algorithm: 
		1)Calculate the sum of first n natural numbers as sumtotal= n*(n+1)/2
		2)Create a variable sum to store the sum of array elements.
		3)Traverse the array from start to end.
		4)Update the value of sum as sum = sum + array[i]
		5)Print the missing number as sumtotal – sum	
		
 *Complexity Analysis: 
	Time Complexity: O(n). 
	Only one traversal of the array is needed.
	Space Complexity: O(1). 
	No extra space is needed		
 */
package arrays;

//import java.util.Arrays;
//import java.util.Collections;

public class MissingElement {
	
	void m1() {
		// Method when starts from 1...
		System.out.println("***Method One***");
		Integer arr[] = {1, 2, 3, 4, 6, 7, 8};
		//The formula of the sum of first n natural numbers is S=n(n+1)2 .
		int l=(arr.length)+1;
		//int max = Collections.max(Arrays.asList(arr));
		int Total=(l*(l+1))/2;
		int ArrTotal=0;
		for(int i=0;i<l-1;i++) {
			ArrTotal+=arr[i];
		}
		System.out.print("Missing Element is: ");
		System.out.println(Total - ArrTotal);
	}
	
	void m2() {
		// Method when doesn't starts from 1...
		System.out.println("***Method Two***");
		Integer arr[] = {11, 12, 13, 14, 16, 17, 18};
		//The formula of the sum of first n natural numbers is S=n(n+1)2 .
		int l=(arr.length);          
		// OR arr[l],l:last element,Here we used just for using function max
		int max = arr[l-1]; //Collections.max(Arrays.asList(arr));
		int Total=(max*(max+1))/2;
		int ArrTotal=0;
		int ArrbeforeTotal=0;
		
		//If array doesn't start from zero, adding all elements till before first element from zero
		//to make it sum from zero to largest element in array.
		for(int i=1;i<arr[0];i++) {
			ArrbeforeTotal+=i;
		}
		
		for(int i=0;i<l;i++) {
			ArrTotal+=arr[i];
		}
		System.out.print("Missing Element is: ");
		System.out.println(Total-(ArrbeforeTotal+ArrTotal));
	}
	
	void m3() {
		// For all types
		System.out.println("***Method Three***");
		int arr[] = {112, 113, 114, 115, 117, 118};
		int l=(arr.length);          
		int max = arr[l-1];
		int min = arr[0];
		int arrTotal=0;
		int totalSum=0;
		
		for(int i=min;i<=max;i++) {
			totalSum+=i;
		}
		//System.out.println("T:"+totalSum);
		
		for(int i=0;i<l;i++) {
			arrTotal+=arr[i];
		}
		//System.out.println("T1:"+arrTotal);
		System.out.println("Missing Element is: "+(totalSum-arrTotal));
	}
	

	static int MissingNo(int arr[], int n) {
		// Method when starts from 1...
		System.out.println("***Method XOR***");
		  int x1 = arr[0];
		  int x2 = 1;

		  for (int i = 1; i < n; i++)
		    x1 = x1 ^ arr[i];

		  for (int i = 2; i <= n + 1; i++)
		    x2 = x2 ^ i;

		  return (x1 ^ x2);
		}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 6, 7, 8};
		//The formula of the sum of first n natural numbers is S=n(n+1)2 .
		int l=(arr.length); 
		 MissingElement me= new MissingElement();
		 me.m1();
		 me.m2();
		 me.m3(); //Efficient
		 int M= MissingNo(arr, l);
		 System.out.print("Missing Element is: "+ M);		 
	}
}
