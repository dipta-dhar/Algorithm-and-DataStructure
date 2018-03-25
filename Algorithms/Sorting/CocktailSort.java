package sorting;

public class CocktailSort {
	
	public static void main(String []args) {
		int[] arr = {2,5,6,4,11,22,10,1};
	    
		System.out.println("Before Sorting:");
	    for(int j=0; j<arr.length; j++)
	    	System.out.print(arr[j] + " ");
		
	    sort(arr);
	    
	    System.out.println("\n\nAfter Sorting:");
	    for(int j=0; j<arr.length; j++)
	    	System.out.print(arr[j] + " ");
	}
	
    public static void sort(int[] array) {
        int start = -1;
        int end = array.length - 2;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = ++start; i <= end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            for (int i = --end; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(int[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}