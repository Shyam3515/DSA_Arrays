/*
 * Link : https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * Video:https://www.youtube.com/watch?v=X5UhF3xS5Dk
 * Question:  Java program to find a triplet
 * Description:Given an array of integers, and a number ‘sum’, 
   find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 * 	Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
	Output: 12, 3, 9 
	Explanation: There is a triplet (12, 3 and 9) present 
	in the array whose sum is 24.
	 
	Input: array = {1, 2, 3, 4, 5}, sum = 9 
	Output: 5, 3, 1 
	Explanation: There is a triplet (5, 3 and 1) present 
	in the array whose sum is 9.
 
 * Method 2 : This method uses sorting to increase the efficiency of the code. 

	Approach: By Sorting the array the efficiency of the algorithm can be improved. 
	This efficient approach uses the two-pointer technique. 
	Traverse the array and fix the first element of the triplet. 
	Now use the Two Pointers algorithm to find if there is a pair whose sum is equal to x – array[i]. 
	Two pointers algorithm take linear time so it is better than a nested loop.
	
	Algorithm : 
	1)Sort the given array.
	2)Loop over the array and fix the first element of the possible triplet, arr[i].
	3)Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum, 
	4)If the sum is smaller than the required sum, increment the first pointer.
	5)Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
	6)Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.
 	
 * Complexity Analysis: 
	Time complexity: O(N^2). 
	There are only two nested loops traversing the array, so time complexity is O(n^2). 
	Two pointers algorithm takes O(n) time and the first element can be fixed using another nested traversal.
	Space Complexity: O(1). 
	As no extra space is required.
 */
package arrays;
import java.util.Arrays;
public class Triplets 
{
	public static void main(String[] args) 
	{
	    int i,c=0,r,l;
	    int sum=24;
		System.out.println("*****Triplets Of Sum*****");
		//int arr[] = { 10,2,8,4,7,6,5,3,9,1 };
		int arr[] = { 12, 3, 4, 1, 6, 9};
		Arrays.sort(arr); //O(nlogn) //1,2,3,4,5,6,7,8,9,10
		int n = arr.length;
		System.out.println("Pairs are:");
		
		/* Now fix the first element one by one and find the
        other two elements */
		for(i=0;i<n-2;i++) 
		{
			l=0;//It should start from 0 in every iteration,to avoid missing of previous elements
			r=n-1;
			 // To find the other two elements, start two index variables
             // from two corners of the array and move them toward each
             // other
             // index of the first element in the remaining elements
             // index of the last element
			while(l<r) {
				if(l==i) // l will be incremented, if it is equal to i
				{
					l++;
					continue;
				}
				if(arr[i]+arr[l]+arr[r]==sum) {
					System.out.println("Triplet is "+"("+arr[i]+","+arr[l]+","+arr[r]+")");
					c++;
                    break;
				}
				else if(arr[i]+arr[l]+arr[r]<sum) {
					l++;
				}
				else { // A[i] + A[l] + A[r] > sum
					r--;
				}
			}// If we reach here, then no triplet was found
			
		}
		
		System.out.println("Number of pairs are: "+c);
	}
}

