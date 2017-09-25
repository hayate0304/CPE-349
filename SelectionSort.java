/*  Java Class:	Lab 1
    Author:		Kien Nguyen
    Class:		CSC 349
    Date:		09/21/2017
    Description: selection sort

    I certify that the code below is my own work.

	Exception(s): N/A
*/


import java.util.*;

import javax.print.attribute.Size2DSyntax;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SelectionSort {
	public static void sort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
	
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	public static void main(String args[]){
		int arr[] = new int[10000];
		int size = 10000;
		ArrayList<Integer> time = new ArrayList<>();
		
		SelectionSort ob = new SelectionSort();
		Random r = new Random();
		
		int low = -10000;
		int high = 10001;
			
		while (size <= 20000){
			for (int i = 0; i < 10000; i++){
				int result = r.nextInt(high - low) + low;
				arr[i] = result;
			}
			
			long start = System.nanoTime();
			SelectionSort.sort(arr);
			long end = System.nanoTime();
			
			long startM = System.nanoTime();
			SelectionSort.sort(arr, 0, arr.length - 1);
			long endM = System.nanoTime();
			
			time.add(size);
			time.add((int) (end-start));
			time.add((int) (endM-startM));
			size += 20;
			
			
		}
		
		for (Integer item : time) {   
		    System.out.println(item);
		}
	}

}

