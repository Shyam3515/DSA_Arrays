/*
 * Link : https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * Video: https://www.youtube.com/watch?v=BHYAldi0EJE
 * Question: Finding Equilibrium point
 * Description:Equilibrium index of an array is an index such that the sum of elements
   at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A: 
	Example : 
		Input: A[] = {-7, 1, 5, 2, -4, 3, 0} 
		Output: 3 
		3 is an equilibrium index, because: 
		A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

		Input: A[] = {1, 2, 3} 
		Output: -1 
		
		
*Algorithm:		
		The idea is to get the total sum of the array first. Then Iterate through the array
		and keep updating the left sum which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one. Thanks to Sambasiva for suggesting this solution and providing code for this.

		1) Initialize leftsum  as 0
		2) Get the total sum of the array as sum
		3) Iterate through the array and for each index i, do following.
		    a)  Update sum to get the right sum.  
		           sum = sum - arr[i] 
		       // sum is now right sum
		    b) If leftsum is equal to sum, then return current index. 
		       // update leftsum for next iteration.
		    c) leftsum = leftsum + arr[i]
		4) return -1 
		
		// If we come out of loop without returning then
		
		// there is no equilibrium index
		 
* My Solution Steps:
 *   1.
 *   2.
 *   
 * Time Complexity/Space Complexity
 * O(n)/O(1)
 * 
 * */
package arrays;
public class EuilibriumPoint {
	public static void main(String[] args) {
		int rightSum=0,leftSum=0,pos=-1;
		int arr[] = {1,3,5,2,2};
		int n=arr.length;
		for(int i=0;i<n;i++) 
		{
			//Add the total values from array to rightSum
			rightSum+=arr[i];
		}
		for(int i=0;i<n;i++) 
		{
			//Subtract every element from rightSum while iterating the loop
			//and compare rightSum with leftSum, if not equal add that element to leftSum
			rightSum-=arr[i];
			if(leftSum==rightSum) {
				pos=i+1;
				System.out.println("Equilibrium Point is:"+pos+", Equilibrium point value:"+arr[i]);
				break;
			}
			// if rightSum and leftSum, not equal add that element to leftSum
			leftSum=leftSum+arr[i];	
			System.out.println("left sum:"+leftSum);
	   }
	   if(leftSum!=rightSum) {
		   System.out.println("No Equilibrium point,hence the result is: "+pos);
	   } 
	}
}
