package dpAlgorithms;

import java.util.Arrays;

public class CoinChange {
	public static int countWays(int s[], int m, int n) {
		int[] arr = new int[n+1];
		
		Arrays.fill(arr, 0);
		arr[0] = 1;
		for(int i=0; i<m; i++) {
			for(int j=s[i]; j<=n; j++) {
				arr[j] += arr[j-s[i]];
			}
		}
		
		return arr[n];
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
		int m = arr.length;
		int n = 4;
		
		System.out.println(countWays(arr, m, n));
	}
}
