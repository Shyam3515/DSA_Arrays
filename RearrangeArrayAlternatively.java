/*
 * Link : https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 * Tech Dose:
 * Video: https://www.youtube.com/watch?v=ZRoVWxBngX0
 * Question: Given a sorted array of positive integers, rearrange the array alternately
 * Description:  first element should be maximum value, 
 *  second minimum value, third second max, fourth second min and so on. 
 *  Examples:
		Input: arr[] = {1, 2, 3, 4, 5, 6, 7} 
		Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
		
		Input: arr[] = {1, 2, 3, 4, 5, 6} 
		Output: arr[] = {6, 1, 5, 2, 4, 3} 
 
 *	Algorithm:
 *       1)Declare an array
 *       2)Get the length and get the Max element by Collections formula or by for loop.
 *       3)Initialize First index as 'min' and last index as 'max'.
 *       4)For Even Index use the given formula and Decrement max index.
 *       5)For Odd Index use the given formula and Increment min index.
 *       
 *  Time Complexity/Space Complexity:
 *    O(n)/O(1)      
 */

package arrays;

import java.util.Arrays;
import java.util.Collections;

public class RearrangeArrayAlternatively {

	public static void main(String[] args) {
		Integer arr[] = {1,2,3,4,5};
		int n=arr.length;//Array length
		int max = Collections.max(Arrays.asList(arr)); //max element
		int min = 0; //Iterator from first
		int M = n-1; //Iterator from back
		int Max =max+1; //Max According to formula(max + 1)
		
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				System.out.println("i="+i+", "+"MAX="+arr[M]+", "+"Max_At_Index= "+M);
				arr[i]=arr[i]+(arr[M]% Max)*Max;
				System.out.println("Arr1:"+arr[i]);
				M--;
			}
			else {
				System.out.println("i="+i+", "+"MIN="+arr[min]+", "+"Min_At_Index="+min);
				arr[i]=arr[i]+(arr[min]% Max)*Max;
				System.out.println("Arr2:"+arr[i]);
				min++;
			}
		}
		System.out.println();
		System.out.println("Original list:");
		for(int ele:arr) {
			System.out.print(ele%Max+" ");
		}
		
		System.out.println();
		System.out.println("Rearranged list:");
		for(int ele:arr) {
			System.out.print(ele/Max+" ");
		}
	}

}
