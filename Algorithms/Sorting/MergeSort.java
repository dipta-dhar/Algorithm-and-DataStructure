package sorting;

public class MergeSort
{
	public static void sort(int[] in) {
	    if(in.length < 2) return; //do not need to sort
	    
	    int mid = in.length/2;
	    int left[] = new int[mid];
	    int right[] = new int[in.length-mid];
	    
	    for(int i=0; i<mid; i++) { //copy left
	        left[i] = in[i];
	    }
	    for(int i=0; i<in.length-mid; i++){ //copy right
	        right[i] = in[mid+i];
	    }
	    sort(left);
	    sort(right);
	    merge(left, right, in);
	}

	private static void merge(int[] a, int[] b, int[] all) {
	    int i=0, j=0, k=0;
	    while(i<a.length && j<b.length) { //merge back
	        if(a[i] < b[j]){
	            all[k] = a[i];
	            i++;
	        }else{
	            all[k] = b[j];
	            j++;
	        }
	        k++;
	    }
	    while(i<a.length) { //left remaining
	        all[k++] = a[i++];
	    }
	    while(j<b.length) { //right remaining
	        all[k++] = b[j++];
	    }
	}

	public static void main(String[] args) {
	    int[] a = {2,3,6,4,9,22,12,1};
	    
	    sort(a);
	    
	    System.out.println("Sorted array is:");
	    for(int j=0; j<a.length; j++) {
	        System.out.print(a[j] + " ");
	    }   
	 }
}