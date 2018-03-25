#include<bits/stdc++.h>
using namespace std;

void PrintArray(int *array, int n) {
  for (int i = 0; i < n; ++i)
    printf("%d ", array[i]);
  printf("\n");
}

void Merger(int arr[], int lo, int  mi, int hi){
    int *temp = new int[hi-lo+1];//temporary merger array
    int i = lo, j = mi + 1;//i is for left-hand,j is for right-hand
    int k = 0;//k is for the temporary array
    while(i <= mi && j <=hi){
        if(arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }
    //rest elements of left-half
    while(i <= mi)
        temp[k++] = arr[i++];
    //rest elements of right-half
    while(j <= hi)
        temp[k++] = arr[j++];
    //copy the mergered temporary array to the original array
    for(k = 0, i = lo; i <= hi; ++i, ++k)
        arr[i] = temp[k];

    delete []temp;
}
void MergeSortHelper(int arr[], int lo, int hi){
    int mid;
    if(lo < hi){
        mid = (lo + hi) >> 1;
        MergeSortHelper(arr, lo, mid);
        MergeSortHelper(arr, mid+1, hi);
        Merger(arr, lo, mid, hi);
    }
}
void MergeSort(int arr[], int arr_size){
    MergeSortHelper(arr, 0, arr_size-1);
}

int main() {
  int array[] = {94, 0, 50, 95, 333, 3, 54, 456, 1, 28};
  int n = sizeof(array)/sizeof(array[0]);

  printf("Before Merge Sort:\n");
  PrintArray(array, n);

  MergeSort(array, n);

  printf("\nAfter Merge Sort:\n");
  PrintArray(array, n);

  return (0);
}
