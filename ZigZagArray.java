/*
 * Link : https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * Video : https://www.youtube.com/watch?v=bgx1eAgBgaQ
 * Video** : https://www.youtube.com/watch?v=ceMTbyQKTCc
 * 
 * Question: Given an array of DISTINCT elements, rearrange the elements of array
    in zig-zag fashion in O(n) time. The converted array should be in form a<b>c<d>e<f.
    
 *  Another approach:
	Since the relation needed is a<b>c<d>e<f, it means the odd position elements
	have to be greater than its adjacent i.e. the even position elements.
	Simply traverse the array at the odd positions and check if it is greater
	than its adjacent elements, if it is not then swap them.
	
 * Time complexity: O(n) 
   Auxiliary Space: O(1) 	
 */

package arrays;

public class ZigZagArray {
	static void swap(int arr[],int a, int b) {
		int temp=0;
		temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	public static void main(String[] args) {
		int[] arr={1,1,1,1};
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			if(i%2==0 && arr[i]>arr[i+1]) {
				swap(arr,i,i+1);
			}
			if(i%2!=0 && arr[i]<arr[i+1]) {
				swap(arr,i,i+1);
			}
		}
		
		System.out.print("Zig-Zag Array is: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
		
	}

}
