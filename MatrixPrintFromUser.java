package arrays;
import java.util.Scanner;

public class MatrixPrintFromUser {
	public static void main(String[] args) {
		//int[][] arr = { { 1, 2 }, { 3, 4 } };
		int i,j;
		int arr[][] =new int[3][3];
		System.out.println("Enter Matrix Elements:");
		Scanner mat=new Scanner(System.in);//Taking Input
		 for (i = 0; i < 3; i++) {
	            for (j = 0; j < 3; j++) {
	            	System.out.print("arrr[" + i + "][" + j + "] = ");
	            	arr[i][j]=mat.nextInt();	
	            }
		 }
		 //Printing Elements
		 System.out.println("Elements are:");
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
       System.out.print(arr[0][0]);
	}
}
