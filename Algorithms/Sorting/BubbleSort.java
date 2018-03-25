
import java.util.Scanner;

class Main
{
    public static void main(String []args) {
        int n, temp;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Total number of elements: ");
        n = in.nextInt();

        int array[] = new int[n];
        System.out.println("Enter " + n + " integers:\n");
        for(int i=0; i<n; i++)
            array[i] = in.nextInt();

        for(int i=0; i<n-1; i++) {
            for(j=0; j<n-i-1; j++) {
                /* For descending order use < */
                if (array[j] > array[j+1]) {
                    temp       = array[j];
                    array[j]   = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted list of numbers:\n");
        for(int i=0; i<n; i++)
            System.out.println(array[i]);
    }
}
