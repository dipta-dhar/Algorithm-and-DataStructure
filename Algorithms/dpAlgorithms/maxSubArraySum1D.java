package dpAlgorithms;


class maxSubArraySum1D {
 
    public static int maxSubArraySum(int a[], int size) {
	    int max_so_far = a[0];
	    int curr_max = a[0];
	 
	    for (int i = 1; i < size; i++) {
	           curr_max = Math.max(a[i], curr_max+a[i]);
	        max_so_far = Math.max(max_so_far, curr_max);
	    }
	    
	    return max_so_far;
    }
    
    public static int maxSubArraySumWithIndex(int a[], int size) {
        int max_so_far = Integer.MIN_VALUE,
        max_ending_here = 0,start = 0,
        end = 0, s = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
 
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
 
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        
        System.out.println("Starting index: " + start);
        System.out.println("Ending   index: " + end);
        
        return max_so_far;
    }
 
    public static void main(String[] args) {
	    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	    
	    int n = a.length;
	    int max_sum = maxSubArraySumWithIndex(a, n);
	    
	    System.out.println("Maximum contiguous sum is: " + max_sum);
    }
}