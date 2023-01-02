/*
 * Link : https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * Video : https://www.youtube.com/watch?v=38JLfQGVlkw
 * Question: Given the arrival and departure times of all trains that reach a 
 *   railway station, the task is to find the minimum number of platforms required
 *   for the railway station so that no train waits. We are given two arrays that
 *   represent the arrival and departure times of trains that stop.
 *   
 *  Examples: 
	 Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} 
	 dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} 
	 Output: 3 
	 Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

 * Algorithm:
	1.Sort the arrival and departure times of trains.
	2.Create two pointers i=0, and j=0, and a variable to store ans and current count plat.
	3.Run a loop while i<n and j<n and compare the ith element of arrival array 
	 and jth element of departure array.
	4.If the arrival time is less than or equal to departure then one more platform
	 is needed so increase the count, i.e., plat++ and increment i
	5.Else if the arrival time is greater than departure then one less platform 
	 is needed to decrease the count, i.e., plat– and increment j
	6.Update the ans, i.e. ans = max(ans, plat).
  
 *  Time Complexity: O(N * log N), One traversal O(n) of both the array is needed after sorting O(N * log N).
	Auxiliary space: O(1), As no extra space is required.
 */
package arrays;

import java.util.Arrays;

public class MinimumPlatformsRequired {

	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		
		//int arr[] = {900, 1100, 1235};
		//int dep[] = {1000, 1200, 1240};
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int i=1,j=0;
		int minreq=1,needplat=1;
		int m=arr.length;
		int n=dep.length;
		
		while(i<m && j<n) {
			if(arr[i]<dep[j]) {
				minreq+=1;
				i++;
				
				if(needplat<minreq) {
					needplat=minreq;
				}
			}
			else {
				minreq--;
				j++;
			}
		}	
		System.out.println("Minimum Platforms Required are: "+needplat);
	}
}
