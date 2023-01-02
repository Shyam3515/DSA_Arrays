/* ### We can do method(3) also for both +ve and -ve numbers ###
 * 
 * Video(1) :https://www.youtube.com/watch?v=I5FTXOFZa0E&t=317s
 * Video(2) : https://www.youtube.com/watch?v=XzwUBIkR9pA
 * Link(1) : https://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * 
 * Method 1: 
 * Efficient Approach: 
    There is an idea if all the elements of the array are positive. 
 	If a subarray has sum greater than the given sum then there is no possibility that adding elements 
 	to the current subarray the sum will be x (given sum). Idea is to use a similar approach to a sliding window. 
 	Start with an empty subarray, add elements to the subarray until the sum is less than x.
  	If the sum is greater than x, remove elements from the start of the current subarray.
   
    Algorithm:  
	1)Create three variables, left=0, cursum = 0
	2)Traverse the array from start to end.
	3)Update the variable sum by adding current element, sum = sum + array[i]
	4)If the sum is greater than the given sum, update the variable sum as sum = sum – array[l], 
	and update left as, left++.
	5)If the sum is equal to given sum, print the subarray and break the loop.
	
 * Time Complexity/Space Complexity
 * O(n)/O(1)	
	
 * Method 2:(Using HashMap)
 * Efficient Approach: : 
	  The idea is to store the sum of elements of every prefix of the array in a hashmap, 
	  i.e, every index stores the sum of elements up to that index hashmap. 
	  So to check if there is a subarray with a sum equal to s, check for every index i, 
	  and sum up to that index as x. If there is a prefix with a sum equal to x – s, 
	  then the subarray with the given sum is found. 
	
 * Algorithm:
 *  1)Create a Hashmap (hm) to store a key-value pair, i.e, key = prefix sum and value = its index, 
 *  and a variable to store the current sum (sum = 0) and the sum of the subarray as s
	2)Traverse through the array from start to end.
	3)For every element update the sum, i.e sum = sum + array[i]
	4)If the sum is equal to s then print that the subarray with the given sum is from 0 to i
	5)If there is any key in the HashMap which is equal to sum – s then print that the subarray
	 with the given sum is from hm[sum – s] to i
	6)Put the sum and index in the hashmap as a key-value pair.	 
	
 * Time Complexity/Space Complexity
 * O(n)/O(n)		 
 */

package arrays;
import java.util.HashMap;
public class SubArrayWithGivenSum {
	void m1() {
		// Works for only Positive Numbers, Time Complexity:O(n)/Space Complexity:O(1)
		int cursum=0,start=0;
	    int sum=6,flag=0;
		System.out.println("Method 1:");
		int arr[] = {2,4,7,6,5,3,9,1,2,3,5,0};
		int n = arr.length;
		for (int i = 0; i<n;i++) 
        {
			cursum+=arr[i];
			System.out.println("I: "+i);
			while(cursum>sum && start<n) 
        	{
				System.out.println("CurSum Before subtraction:"+cursum);
				System.out.println("start:"+start);
        		cursum-=arr[start];
        		System.out.println("CurSum After subtraction:"+cursum);
        		start++;
        	}
        	if(cursum==sum) {
        		System.out.println("CurSum1:"+cursum);
        		flag=1;
        		System.out.println("The Sub Array is present in Index: "+"("+start+","+i+")");
        		//break;//remove break to see all outcomes
        	}
        }
    	if(flag==0) 
    	{
    		System.out.println("SubArray Not Found");        		
    	}        	 
	}
	
	
    void m2(int[] arr, int sum,int n) {
    	// Works for both Positive  and negative Numbers,Time Complexity:O(n)/Space Complexity:O(n)
    	System.out.println("*Method 2:");
    	int cursum=0,start=0,end=-1;
    	HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) 
        {	//{2,4,-7,-6,5,3,4,-9,1,-2,3,5,0};
        	cursum+=arr[i]; //Adding values to cursum
        	if(cursum-sum==0) {
        		start=0;
        		end=i;
        		break;
        	}
        	
        	if(map.containsKey(cursum-sum)) {  //cursum = (cursum-sum) + sum
        		//our sum index starts from the next index of (cursum-sum), that's why adding 1.
        		start=map.get(cursum-sum)+1;
        		end=i;
        		break;
        	}
        	// After adding values into cursum checking whether sum present or not
        	map.put(cursum,i); //else adding cursum to Hash-map,And again comparing from there
        	System.out.println("map:"+map);
        }                      
        
        if(end==-1) {
        	System.out.println("SubArray Not Found");
        }
        else {
        	System.out.println("The Sub Array is present in Index: "+"("+start+","+end+")");
        }
    }
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	    int sum=12;
		System.out.println("*****SubArray With given Sum*****");
		int arr[] = {2,4,-7,-6,5,3,4,-9,1,-2,3,5,0,12};
		int n = arr.length;
		SubArrayWithGivenSum sub= new SubArrayWithGivenSum();
		sub.m1();
		sub.m2(arr, sum, n);
		
		
	}
}
