//Max of Sub array Sum

/* Link :https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Vivekanand
 * Video:https://www.youtube.com/watch?v=kekmCQXYwQ0
 * Question:Write an efficient program to find the sum of contiguous subarray 
   within a one-dimensional array of numbers that has the largest sum. 
   
 * Kadane’s Algorithm:

		Initialize:
		    max_so_far = INT_MIN
		    max_ending_here = 0
		
		Loop for each element of the array
		  (a) max_ending_here = max_ending_here + a[i]
		  (b) if(max_so_far < max_ending_here)
		            max_so_far = max_ending_here
		  (c) if(max_ending_here < 0)
		            max_ending_here = 0
           return max_so_far
           
* Explanation: 
	  The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array
	  (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments
	  (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far 
	  and update max_so_far if it is greater than max_so_far 
  
 * Time Complexity/Space Complexity:
 *  O(n)/O(1)
 */
package arrays;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int arr[] = {1,-2,1,-3,4,2,1,3,2,-5,1,1};
		int sum=0;
		int max_so_far=arr[0];
		int n=arr.length;
		int start=0,s=0,end=0;
		
		for(int i=0;i<n;i++) 
		{
			sum+=arr[i];
			if(max_so_far<sum) {
				max_so_far=sum;
				start=s;//starting index
				end=i;//ending index
			}
			if(sum<0){
				sum=0;
				s=i+1; // next start..
			}
	    }
		System.out.println("starting index:"+start+", "+"Ending index:"+end);
		System.out.println("The Elements are:");
		System.out.print("-->");
		for(int i=start;i<=end;i++) {
		  System.out.print(" "+arr[i]+" ");//Printing the sum of elements from start to end
		}
	}
}
