using System;
 
class maxSubArraySum1D
{
    static int maxSubArraySum(int []a, int size) {
		int max_so_far = a[0];
		int curr_max   = a[0];
	
		for (int i = 1; i < size; i++) {
			curr_max = Math.Max(a[i], curr_max+a[i]);
			max_so_far = Math.Max(max_so_far, curr_max);
		}
	
		return max_so_far;
    }
 
    public static void Main () {
        int []a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.Length;
        Console.Write("Maximum contiguous sum is: " + maxSubArraySum(a, n));
    }
}