package dpAlgorithms;

import java.util.Arrays;

public class LIS {
	
	public static int recursiveLIS(int arr[], int i, int n, int prev) {
		/*
			Complexity: O(2^n)
		*/
		if (i == n)
			return 0;
		
		int excl = recursiveLIS(arr, i+1, n, prev);
		
		int incl = 0;
		if (arr[i] > prev) {
			incl = 1 + recursiveLIS(arr, i+1, n, arr[i]);
		}
		
		return Integer.max(incl, excl);
	}
	
	public static int dpLIS(int arr[]) {
		/*
			Complexity: O(n log n)
		*/
		int[] L = new int[arr.length];
		
		L[0] = 1;
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if (arr[j]<arr[i] && L[j]>L[i]) {
					L[i] = L[j];
				}
			}
			L[i]++;
		}
		
		return Arrays.stream(L).max().getAsInt();
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		///int len = recursiveLIS(arr, 0, arr.length, Integer.MIN_VALUE);
		int lis_len = dpLIS(arr);
		System.out.println("Length os LIS is: " + lis_len);
	}
}
