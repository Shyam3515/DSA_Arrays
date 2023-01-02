/*
 * Link : https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 * Video: https://www.youtube.com/watch?v=xF3TU-QlhJQ&t=430s
 * Question: Given two sorted arrays, the task is to merge them in a sorted manner.
 *   Examples: 
		Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
		Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
		
		Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8} 
		Output: arr3[] = {4, 5, 7, 8, 8, 9} 
 
 *Algorithm:
	1)The idea is to use Merge function of Merge sort. 
	
	2)Create an array arr3[] of size n1 + n2.
	3)Simultaneously traverse arr1[] and arr2[]. 
	4)Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
	5)If there are remaining elements in arr1[] or arr2[], copy them also in arr3[].	
 
 *Time Complexity/Space Complexity:
 *(O(n1 + n2) Time and O(n1 + n2) Extra Space) 		
 *
 */

package arrays;
import java.util.ArrayList;
import java.util.List;
public class MergeSortedArrays {

	public static void main(String[] args) {
		int arr1[] = {1, 3, 4,5 ,7}; 
		int arr2[] = {0 ,2 ,4,6 ,8, 9};
		List<Integer> list = new ArrayList<Integer>();
		int n = (arr1.length);
		int m = (arr2.length);
		int i=0,j=0;
		
		while(i<n &&j<m)
		{
			if(arr1[i] < arr2[j]) {
				list.add(arr1[i]);
				i++;
			}
			else {
				list.add(arr2[j]);
				j++;	
			}
	    }
		while(i<n) 
		{
			
			list.add(arr1[i]);
			i++;
		}
		while(j<m) {
			list.add(arr2[j++]);
		}
		System.out.println("Final Sorted list:");
		System.out.println(list);
	}
}
