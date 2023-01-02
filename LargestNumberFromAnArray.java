/*
 * Video : https://www.youtube.com/watch?v=qEIGhVtZ-sg
 * Link : GeeksforGeeks just for Algorithm.
 * Question : Given an array of numbers, arrange them in a way that yields 
 	the largest value. For example, if the given numbers are {54, 546, 548, 60},
    the arrangement 6054854654 gives the largest value.
    
 * Algorithm:
    1)Given two numbers X and Y, how should myCompare() decide which number to put first 
     – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). 
    2)If XY is larger, then X should come before Y in output, else Y should come before. 
    3)For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542.
     Since 60542 is greater than 54260, we put Y first. 
     
 * Time Complexity/Space Complexity:
    O(nlogn)/O(1) 
    nlogn- Because as we decrease the value of i, j iterates next from i.    
 */
package arrays;

public class LargestNumberFromAnArray {

	public static void main(String[] args) {
		int[] arr=  {1, 20, 6, 4, 5 };;
		int n=arr.length;
		
		for(int i=0;i<n-1;i++) {//taken n-1,because j will be i+1.
			for(int j=i+1;j<n;j++) {
				//converting values to string and concatenating them
				String a=String.valueOf(arr[i]);
				String b=String.valueOf(arr[j]);
				
				String con1=a+b;
				String con2=b+a;
				//If first value less than second swap.
				if(Integer.parseInt(con1) < Integer.parseInt(con2)) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		//Printing array
		System.out.print("Largest Number formed from Array is: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
	}
}
