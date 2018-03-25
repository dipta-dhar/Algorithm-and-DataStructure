package searchingAndTraversal;

import java.util.Arrays;
import java.util.Scanner;


public class BinarySearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int arr[] , n, searchValue;

	    System.out.print("Enter the number of elements: ");
	    n = in.nextInt();
	    arr = new int[n];

	    System.out.printf("Enter %d elements:\n", n);
	    for(int i=0; i<n; i++)
	        arr[i] = in.nextInt();
	    
	    System.out.printf("Enter the search value: ");
	    searchValue = in.nextInt();

	    Arrays.sort(arr);
	    System.out.printf("\n\nSorting list is:\n", n);
	    for(int i=0; i<n; i++)
	    	System.out.printf("%d ", arr[i]);
	    System.out.printf("\n\n");

	    binarySearch(arr, n, searchValue);
	    
	    in.close();
	}
	
	public static void binarySearch(int[] arr, int n, int searchValue) {
		int first = 0;
	    int last = n - 1;
	    int middle = (first+last)/2;

	    while(first <= last) {
	        if (arr[middle] < searchValue)
	            first = middle + 1;

	        else if (arr[middle] == searchValue) {
	        	System.out.printf("%d is found at location %d.\n", searchValue, middle+1);
	            return;
	        }
	        else last = middle - 1;

	        middle = (first + last)/2;
	    }
	    System.out.printf("%d isn't present in the array.\n", searchValue);
	}
}
