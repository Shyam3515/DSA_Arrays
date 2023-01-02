package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	public static void main(String[] args)
    {
    	int[] arr= {3,1,2,2,2};
    	int n=arr.length;
    	
    	ArrayList<Integer> List=new ArrayList<Integer>();
    	
    	for(int i=0;i<n-1;i++) {
			if(arr[i]!=arr[i+1]) {
				List.add(arr[i]);
			}
		}

		List.add(arr[n-1]);
		int n1=List.size();
		System.out.println(n1);
		
    }
}

