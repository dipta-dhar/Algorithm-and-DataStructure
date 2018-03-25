package sorting;

public class ShellSort{

    public static void main(String []args){
        int[] a = {9,8,7,6,5,4,3,2,1};
        
        System.out.println("Before Shell Sort:");
        for(int i=0; i<a.length; i++)
        	System.out.print(a[i] + " ");
        
        shellSort(a);
        
        System.out.println("\n\nAfter Shell Sort:");
        for(int i=0; i<a.length; i++)
        	System.out.print(a[i] + " ");
    }

    //Performs a shell sort
    public static int[] shellSort(int[] array){
        int h = 1;
        while (h < array.length) h = 3*h + 1;
        while (h > 0){
            h = h/3;
            for (int k = 0; k < h; k++){
                for (int i = h+k; i < array.length; i+=h){
                    int key = array[i];
                    int j = i-h;
                    while (j>=0 && array[j] > key){
                        array[j+h] = array[j];
                        j-=h;
                    }
                    array[j+h] = key;
                    //-> invariant: array[0,h,2*h..j] is sorted
                }
            }
            //->invariant: each h-sub-array is sorted
        }
        return array;
    };
}