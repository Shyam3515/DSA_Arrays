package arrays;

public class SecondLargestElement {
	public static void main(String[] args) {
		int[] arr= {10,46,34,7,82,43,6,48,94};
		int max1=arr[0];
		int max2=arr[1];
		int l=arr.length;
		for(int i=0;i<l;i++) {
			if(arr[i]>max1){
				max2=max1;
				max1=arr[i];
				System.out.println("The First1 is: "+max1);
				System.out.println("The Second1 is: "+max2);
			}
			//when first already has highest,so it can't be less than second highest
			//so automatically,second highest gets assigned to max2.
			else if(arr[i]<max1 && arr[i]>max2){
				max2=arr[i];
				System.out.println("The First is: "+max1);
				System.out.println("The Second is: "+max2);
			}
		}
		System.out.println("The First Largest Element is: "+max1);
		System.out.println("The Second Largest Element is: "+max2);
	}
}
