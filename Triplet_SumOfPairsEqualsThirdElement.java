/*
 *  Link : https://www.geeksforgeeks.org/find-triplet-sum-two-equals-third-element/
 *  Question : Given an array of integers, you have to find three numbers 
              such that the sum of two elements equals the third element.
	Examples: 
	Input : {5, 32, 1, 7, 10, 50, 19, 21, 2}
	Output : 21, 2, 19
	
	Input : {5, 32, 1, 7, 10, 50, 19, 21, 0}
	Output : no such triplet exist
	
 *	Efficient approach: The idea is similar to Find a triplet that sum to a given value.  
	
	Algorithm:
	1)Sort the given array first.
	2)Start fixing the greatest element of three from the back and traverse the array
	  to find the other two numbers which sum up to the third element.
	3)Take two pointers j(from front) and k(initially i-1) to find the smallest 
	  of the two number and from i-1 to find the largest of the two remaining numbers
	4)If the addition of both the numbers is still less than A[i], then we need to 
	  increase the value of the summation of two numbers, thereby increasing 
	  the j pointer, so as to increase the value of A[j] + A[k].
	5)If the addition of both the numbers is more than A[i], then we need to 
	  decrease the value of the summation of two numbers, thereby decrease 
	  the k pointer so as to decrease the overall value of A[j] + A[k].
	  
 * Time Complexity/Space Complexity:
    O(n^2)/O(1)      
 */
package arrays;

import java.util.Arrays;

public class Triplet_SumOfPairsEqualsThirdElement {
	
	static void findTriplet(int arr[],int n) {
		// sort the array
        Arrays.sort(arr);
        int flag=0;
        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
           
            while (j < k) {
                if (arr[i] == arr[j] + arr[k]) {
                    // pair found
                	flag=1;
                    System.out.println("The Triplets are: "+arr[j] +","+ arr[k] + "," + arr[i]);
                    break;
                }
                else if (arr[i] > arr[j] + arr[k])
                    j += 1;
                else
                    k -= 1;
            }
        }
        // no such triplet is found in array
        if(flag==0) {
        	System.out.println("No such triplet exists");
        }
    }	

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 8, 6, 4};
		int length = arr.length;
		findTriplet(arr,length);

	}
}
