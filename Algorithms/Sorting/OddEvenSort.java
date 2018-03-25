package sorting;

public class OddEvenSort {
	public static void main(String []args) {
		int[] arr = {2,5,6,4,11,22,10,1};
	    
		System.out.println("Before Sorting:");
	    for(int j=0; j<arr.length; j++)
	    	System.out.print(arr[j] + " ");
		
	    oddEvenSort(arr);
	    
	    System.out.println("\n\nAfter Sorting:");
	    for(int j=0; j<arr.length; j++)
	    	System.out.print(arr[j] + " ");
	}
	
	public static void oddEvenSort(int[] arr) {
		boolean sort = false;
		
		while(!sort) {
			sort = true;
			
			//For odd index
			for(int i=1; i<arr.length-1; i += 2) {
				if (arr[i] > arr[i+1]) {
					int tem = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tem;
					
					sort = false;
				}
		    }
			
			//For even index
			for(int i=0; i<arr.length; i += 2) {
				if (arr[i] > arr[i+1]) {
					int tem = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tem;
					
					sort = false;
				}
		    }
		}
	}
}
