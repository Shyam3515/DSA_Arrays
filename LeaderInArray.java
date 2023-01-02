/*
 * Link : https://www.geeksforgeeks.org/leaders-in-an-array/
 * Video: https://www.youtube.com/watch?v=M0ffPDQ3cgY
 * Question: Write a program to print all the LEADERS in the array.
 * Description: An element is leader if it is greater than all the elements to its right side. 
   And the rightmost element is always a leader. For example:
     Input:  {16, 17, 4, 3, 5, 2}
     Output: 17, 5 and 2. 
     
   Algorithm:
	Method 2 (Scan from right) 
	1)Scan all the elements from right to left in an array and keep track of maximum till now.
	2)When maximum changes its value, print it.  
	
 *
 * Time Complexity/Space Complexity
    O(n)/O(n)
 */
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {

	public static void main(String[] args) {
		int arr[] = {15,16,9,8,3,2,6,1,4};
		List<Integer> list = new ArrayList<Integer>();
		int n = (arr.length);
		int max=arr[n-1];
	
		//n-1 is the last element and checking whether it is max or not, and similarly for other elements
		for(int i=n-1;i>=0;i--) 
		{
			if(arr[i]>=max) {
				//If an element is greater than max print it
				 System.out.println("The Leaders are: "+arr[i]+"  At position "+i);
				 max=arr[i];//After printing assign the greatest element to max.
				 list.add(arr[i]);//Adding max elements to another list
			}
		}
		//printing them in reverse order as we move from right to left.
		Collections.reverse(list);
		System.out.print("In Correct order:"+list);
	}   
}
