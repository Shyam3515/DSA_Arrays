//(Dutch National Flag Problem)
/*
 * Link : https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * Question: Given an array A[] consisting only 0s, 1s and 2s. 
		  The task is to write a function that sorts the given array. 
		  The functions should put all 0s first, then all 1s and all 2s in last.
		  
 	Examples:
	Input: {0, 1, 2, 0, 1, 2}
	Output: {0, 0, 1, 1, 2, 2}
	
	Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
	Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
	
 * Algorithm:
	1)Keep three indices low = 1, mid = 1 and high = N and there are four ranges,
	 1 to low (the range containing 0), low to mid (the range containing 1),
	  mid to high (the range containing unknown elements) and high to N (the range containing 2).
	2)Traverse the array from start to end and mid is less than high. 
	(Loop counter is i)
	3)If the element is 0 then swap the element with the element at index
	 low and update low = low + 1 and mid = mid + 1
	4)If the element is 1 then update mid = mid + 1
	5)If the element is 2 then swap the element with the element at index 
	high and update high = high – 1 and update i = i – 1. As the swapped element is not processed
	6)Print the array.	 
	
 *  Time Complexity: O(n). 
	Only one traversal of the array is needed.
	Space Complexity: O(1). 
	No extra space is required.	
	
 */
package arrays;

public class SortingOf_0s1s2s {
	
	static void swap(int arr[],int a, int b) {
		int temp=0;
		temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	static void sort(int arr[], int n) {
		int l=0,m=0;
		int h=n-1;
		//System.out.println("h:"+h);
		while(m<=h){
			switch(arr[m]) {
				case 0: {
						swap(arr,m,l);
						l++;
						m++;
						//System.out.println("l,m:"+l+","+m);
						break;
					}
				
				case 1: {
					m++;
					//System.out.println("m:"+m);
					break;
				}
				
				case 2: {
					swap(arr,m,h);
					h--;
					//System.out.println("h:"+h);
					break;
				}
			}
			//System.out.println(l+","+m+","+h);
		}
	}

	public static void main(String[] args) {
		int arr[]= {2, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n=arr.length;
		sort(arr,n);//calling function
		System.out.println("New Array is:");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}		
	}
}
