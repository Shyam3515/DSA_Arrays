/*
 * Link: https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * Video: https://www.youtube.com/watch?v=s1xA_K1JReo
 * Question: Finding Pairs for a sum
 * Description:Given an array of integers, and a number ‘sum’, 
   find the number of pairs of integers in the array whose sum is equal to ‘sum’.
		Examples:  
		Input  :  arr[] = {1, 5, 7, -1}, 
		          sum = 6
		Output :  2
		
		Pairs with sum 6 are (1, 5) and (7, -1)
		Input  :  arr[] = {1, 5, 7, -1, 5}, 
		          sum = 6
		Output :  3
		
		Pairs with sum 6 are (1, 5), (7, -1) &
		                     (1, 5)         
		Input  :  arr[] = {1, 1, 1, 1}, 
		          sum = 2
		Output :  6
		There are 3! pairs with sum 2.
		
		Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
		                   5, 4, 2, 1, 1, 1}, 
		          sum = 11
		Output :  9
 * 
 * Algorithm:
 * Efficient solution – 
	A better solution is possible in O(n) time. 
	Below is the Algorithm – 
		1. Create a map to store frequency of each number in the array. 
		(Single traversal is required)
		2. In the next traversal, for every element check if it can be combined with any other element 
		(other than itself!) to give the desired sum. Increment the counter accordingly.
		3. After completion of second traversal, we’d have twice the required value stored in counter
		 because every pair is counted two times. Hence divide count by 2 and return.
 * 
 * My Solution Steps:
 *   1. Declare an Array With 'n' Elements.
 *   2. Store those Elements in a Hashmap With Frequency.
 *   3. Verify Whether there are elements of pairs With sum, that matches the given sum.
 *   4. Verifying whether the element is in HashMap and checking whether it is half of sum or frquency greater than 1.
 *   5. Increment Count,if it satisfies the above condition.
 *   6. After the loop Divide the Count by '2', to avoid duplicate pairs.
 * 
 * Time Complexity/Space Complexity
 * O(n)/O(n)
 */
package arrays;

import java.util.Arrays;
import java.util.HashMap;
public class PairsOfSum {
	
	static void m2() {
		int i=0,c=0;
		    int sum=10;
			System.out.println("*****Pairs Of Sum*****");
			int arr[] = { 10,2,8,4,7,6,5,5,5,3,9,1,0 };
			Arrays.sort(arr); //O(nlogn)
			int j = arr.length-1;
			System.out.println("Pairs are:");
			while(i<j) // O(n)//Two point technique
			{
			    if((arr[i]+arr[j])>sum)
			    {
			        j--;
			    }
			    else if((arr[i]+arr[j])<sum)
			    {
			        i++;
			    }
			    else
			    {
			        
			        System.out.println("("+arr[i]+","+arr[j]+")");
			        c=c+1;
			        j--;
			    }
			}   
			System.out.println("Number of pairs are:"+c);
			
		}
	
	public static void main(String[] args) {
		int c=0;
	    int sum=10;
		System.out.println("*****Pairs Of Sum*****");
		int arr[] = {10,2,8,4,7,6,5,3,9,1,2,3,5,0};
		int n = arr.length;
		
		HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) 
        {
           if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }
        System.out.println("Elements in Map are:"+map);
        System.out.println("The Pairs are:");
        for (int i = 0; i <n; i++) 
        {
        	//Sum-arr[i]:Sum-Element[i] in map
        	//(If Sum-Element[i] is there in map it means Sum=(Element in map)+(Element[i])
        	//sum-arr[i]!=sum/2: To avoid having of Single Element
        	// For example element:5,Sum=10, then we have to stop count 5
        	// map.get(arr[i])>1): To stop duplicate element pair
            if(map.containsKey(sum-arr[i]) && (sum-arr[i]!=sum/2 || map.get(arr[i])>1))
            {
                int b=sum-(arr[i]);
                System.out.println("("+arr[i]+","+b+")");
                // reducing count in map, to avoid duplicate element pair
                // If 5 present three times it should pair up (5,5),(5,5) to avoid single element
                // If element frequency is "one" then it should not pair with given sum/2
                map.put(arr[i], map.get(arr[i]) - 1); 
                c++;
            }
        }
        System.out.println();
        // Each Element Counted two times,So we are getting duplicate pairs
        // C/2 will give unique pair count
        System.out.println("Number of Pairs Without duplicate:"+c/2) ;
        System.out.println("Elements in Map are:"+map);
        
        System.out.println("Method 2:");
        m2();
		
	}
}
