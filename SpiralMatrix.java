/*
 * Link:https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * video:https://www.youtube.com/watch?v=TmweBVEL0I0&t=426s
 * 
 * 
 * Question: Given a matrix of size r*c. Traverse the matrix in spiral form.
 * Description:Given a 2D array, print it in spiral form. See the following examples..
 * 
 * Examples: 
		Input:  1    2   3   4		
		        5    6   7   8	
		        9   10  11  12
		        13  14  15  16
		Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		Explanation: The output is matrix in spiral format. 
		
		Input:  1   2   3   4  5   6
		        7   8   9  10  11  12
		        13  14  15 16  17  18
		Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
		Explanation :The output is matrix in spiral format.
		
 * Algorithm:
	  * Efficient solution – 
		Method 2: This is a simple method to solve the following problem. 
		Approach: The problem can be solved by dividing the matrix into loops or squares or boundaries. 
		It can be seen that the elements of the outer loop are printed first in a clockwise manner then the elements of the inner loop is printed.
	    So printing the elements of a loop can be solved using four loops which prints all the elements. Every ‘for’ loop defines a single direction movement along with the matrix. 
	    The first for loop represents the movement from left to right, whereas the second crawl represents the movement from top to bottom, the third represents the movement from the right to left, 
	    and the fourth represents the movement from bottom to up.
	
	Algorithm: 
	* Create and initialize variables k – starting row index, m – ending row index,
	  l – starting column index, n – ending column index
	* In each outer loop traversal print the elements of a square in a clockwise manner.
	* Print the top row, i.e. Print the elements of the kth row from column index l to n,
	  and increase the count of k.
	* Print the right column, i.e. Print the last column or
	  n-1th column from row index k to m and decrease the count of n.
	* Print the bottom row, i.e. if k < m, then print the elements 
	  of m-1th row from column n-1 to l and decrease the count of m
	* Print the left column, i.e. if l < n, then print the elements of 
	  lth column from m-1th row to k and increase the count of l.

 * Complexity Analysis: 
	Time Complexity: O(m*n). 
	To traverse the matrix O(m*n) time is required.
	Space Complexity: O(1). 
	No extra space is required.	
 * 
 * */

package arrays;
public class SpiralMatrix {
	public static void main(String[] args)
	{
		System.out.println("Spiral Matrix:");
		int i,row=0,col=0;
		int last_row=3,last_col=4;
		
		/* row- starting row index
        last_row - ending row index
        col - starting column index
        last_col - ending column index
        i - iterator
    */
		        
	 //Display Spiral Form Of Matrix
		int arr[][] = { { 1, 2, 3,11,21},
                		{ 4, 5, 6,12,22},
                		{ 7, 8, 9,13,23 },
                		{ 13, 14, 15,16,24 }
	            		};
		
		//While printing in spiral form row shoudn't move to lastrow and col to lastcol
		while(row<=last_row && col<=last_col) 
		{
			/* Print the first row from
            the remaining rows */
			for(i=col;i<=last_col;i++){
				System.out.print(arr[row][i]+" ");
				
			}
			row++;//As first row is printed it should move to next row
			
			 /* Print the last column
	         from the remaining columns */
			for(i=row;i<=last_row ;i++){
				System.out.print(arr[i][last_col]+" ");
				
			}
			last_col--;
			
			/* Print the last row from
            the remaining rows */
			if(row<=last_row){
	    		for(i=last_col;i>=col;i--){
	    			System.out.print(arr[last_row][i]+" ");	
	    		}
	    		last_row--;
			}	
			
			/* Print the first column from
            the remaining columns */
			if(col<=last_col){
	    		for(i=last_row;i>=row;i--)
	    		{
	    			System.out.print(arr[i][col]+" ");
	    		}
	    		col++;
			}
		}
	}
}
