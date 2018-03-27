package Backtracking;

public class subsetSum {
    public static void main(String[] args) {
        int[] input = {10, 7, 5, 18, 12, 20, 15};
        int targetSum = 45;
        subsetSum subSetSum = new subsetSum();
        subSetSum.findSubSets(input, targetSum);
    }

    private int[] set;
    private int[] selectedElements;
    private int targetSum;
    private int numOfElements;

    public void findSubSets(int[] set, int targetSum) {
        this.set = set;
        this.numOfElements = set.length;
        this.targetSum = targetSum;
        selectedElements = new int[numOfElements];
        quicksort(set, 0, numOfElements-1);
        int sumOfAllElements = 0;
        for(int element : set){
            sumOfAllElements += element;
        }
        findSubSets(0, 0, sumOfAllElements);
    }

    private void findSubSets(int sumTillNow, int index, int sumOfRemaining) {
        selectedElements[index] = 1; // selecting element at index : 'index'
        if (targetSum == set[index] + sumTillNow) {
            print();
        }

        // (sum + set[index] + set[index+1] <= targetSum) : this condition
        // ensures selecting
        // the next element is useful and the total sum by including next
        // element will not exceed the target sum.
        if ((index + 1 < numOfElements) && (sumTillNow + set[index] + set[index + 1] <= targetSum)) {
            findSubSets(sumTillNow + set[index], index + 1, sumOfRemaining - set[index]);
        }

        // now exploring the other path: not Selecting the element at index:
        // 'index'
        selectedElements[index] = 0;

        // (sum + set[index+1] <= targetSum) : this condition ensures selecting
        // the next element is useful and the total sum by including next
        // element will not exceed the target sum.

        // (sum + sumOfRemaining - set[index] >= targetSum) ensures the total
        // sum of all the elements by excluding the current element may achieve
        // the target sum, if in case the resultant sum is less than the target
        // sum then exploring this path is of no use
        if ((index + 1 < numOfElements) && (sumTillNow + set[index + 1] <= targetSum)
                && (sumTillNow + sumOfRemaining - set[index] >= targetSum)) {
            findSubSets(sumTillNow, index + 1, sumOfRemaining - set[index]);
        }
    }

    private void print() {
        for (int i = 0; i < numOfElements; i++) {
            if (selectedElements[i] == 1) {
                System.out.print(set[i]+" ");
            }
        }
        System.out.println();
    }

    private void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            swap(arr, (start + (end - start) / 2), end);
            int pIndex = partition(arr, start, end);
            quicksort(arr, start, pIndex - 1);
            quicksort(arr, pIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pIndex = start, pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr,pIndex,i);
                pIndex++;
            }
        }
        swap(arr,pIndex,end);
        return pIndex;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}