package sorting;

public class InsertionSort {

	public static void main (String[] args)
    {
        int a[] = {16, 19, 11, 15, 10, 12, 14};
        for(int i=0; i<a.length; i++) {
            int j = i;

            //i is not the first element
            while(j>0) {
                //not in order
                if(a[j-1] > a[j]) {
                    //swapping
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
                //in order
                else
                	break;
                j--;
            }
        }

        for(int x : a) {
            System.out.print(x + " ");
        }
    }
}
