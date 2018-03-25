package searchingAndTraversal;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int arr[] , n, searchValue;

	    System.out.print("Enter the number of elements: ");
	    n = in.nextInt();
	    arr = new int[n];

	    System.out.printf("Enter %d elements:\n", n);
	    for(int i=0; i<n; i++)
	        arr[i] = in.nextInt();

	    System.out.print("Enter the search value: ");
	    searchValue = in.nextInt();

	    linearSearch(arr, n, searchValue);
	    
	    in.close();
	}
	
	public static void linearSearch(int[] arr, int n, int searchValue) {
	    for(int i=0; i<n; i++) {
	        if (arr[i] == searchValue) {
	        	System.out.printf("%d is present at location %d.\n", arr[i], i+1);
	            return;
	        }
	    }
	    System.out.printf("%d isn't present in the array.\n", searchValue);
	}
}
