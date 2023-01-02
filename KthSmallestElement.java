package arrays;

public class KthSmallestElement {
	int partition (int a[], int start, int end)  
    {  
        int pivot = a[end]; // pivot element  
        int i = start; //Consider first element(PIndex)

        for (int j = start; j <end; j++)  
        {  
            // If current element is smaller than the pivot  
            if (a[j] <= pivot)  
            {  
                // increment index of smaller element  
                int t = a[i];  //Swap that element with starting element
                a[i] = a[j];  
                a[j] = t;  
                 i++;
            }  
        }  
        int t = a[i];  
        a[i] = a[end]; //swap end  with i(element)
        a[end] = t; 
        
        return i;  
    }  
	
	/* function to implement quick sort */  
    int quick(int a[], int start, int end,int k) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
    {  
            //Comparing indexes
            int p = partition(a, start, end);//p is partitioning index  
            System.out.println("P:"+a[p]+","+p);
            if(p==k-1) {
            	return a[p];
            }
            else if(p<k-1) {
            	return quick(a, p + 1, end,k);  
            }
            return quick(a, start, p - 1,k); 
            
    }  

	public static void main(String[] args) {
		 int a[] = {23,12,45,67,23,78,96};  
         int n = a.length;  
         int k=3;
        if(k>n) {
        	 System.out.println("Enter K value less than or equals: "+n);
         }
        else {  
         KthSmallestElement q1 = new KthSmallestElement();    
         int kth= q1.quick(a, 0, n - 1,k);//Calling Quick sort  
		System.out.println("Kth smallest element is: "+kth);
        }
	}

}
