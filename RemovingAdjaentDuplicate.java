/*
 * Link : geeksforgeeks.org/java-program-to-remove-duplicate-elements-from-the-array/
 * Method 2: (Constant extra space)
 * 
 * Time Complexity: O(n)
   Auxiliary Space: O(1) 
 */

package arrays;

public class RemovingAdjaentDuplicate {
	public static int removeDuplicates(int a[], int n)
    {
		 // if(array size if 0 or 1 array is already sorted)
	    if (n == 0 || n == 1) {
	        return n;
	    }	
	    int j = 0;	
	    // check if the ith element is not equal to 
	    // the (i+1)th element, then add that element
	    // at the jth index in the same array
	    // which indicates that the particular element 
	    // will only be added once in the array
	    for (int i = 0; i < n-1; i++) {
	        if (a[i] != a[i + 1]) {
	            a[j] = a[i];
	            System.out.println("i:"+i+",j:"+j+","+a[i]);
	            j++;
	        }
	    }
	    a[j++]=a[n-1];
	    return j;
}

	public static void main(String[] args) {
		 int a[] = { 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6 };
		    int n = a.length;    
		    int k = 0;
		    // the function will modify the array a[]
		    // such that the starting k elements 
		    // will be having all unique elements 
		    // and no element will be appearing more than
		    // once
		    k = removeDuplicates(a, n);   
	        // printing array elements
	        for (int i = 0; i < k; i++)
	            System.out.print(a[i] + " ");
		    
	}
}
