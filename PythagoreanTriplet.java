/*
 *  Link : https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 *  Question : Given an array of integers, write a function that returns true if there is a triplet
 *    (a, b, c) that satisfies a2 + b2 = c2.
 *    
 *   Algorithm :
 *   	1) This is same as sum of pairs equal to third element in an array.
 *   	2) The change is we squares instead of normal element.
 *    
 *  Time Complexity/Space Complexity:
    O(n^2)/O(1)  
 */
package arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
	static void findTriplet(int arr[],int n) {
		// sort the array
        Arrays.sort(arr);
        int flag=0;
        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
           
            while (j < k) {
                if ((arr[i])*(arr[i]) == (arr[j])*(arr[j]) + (arr[k])*(arr[k])) {
                    // pair found
                	flag=1;
                    System.out.println("The Triplets are: "+arr[j] +","+ arr[k] + "," + arr[i]);
                   break;
                }
                else if (((arr[i])^2) > ((arr[j])^2) + ((arr[k])^2))
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
		
			int[] arr = {3, 2, 4, 6, 5};
			int length = arr.length;
			findTriplet(arr,length);
	}
}
