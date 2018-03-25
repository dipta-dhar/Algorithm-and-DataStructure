#include<bits/stdc++.h>
#include<windows.h>
using namespace std;

void routine(void *a) {
    int n = *(int *) a;
    Sleep(n*1000);
    printf("%d ", n);
}

void sleepSort(int arr[], int n) {
    HANDLE threads[n];

    // Create the threads for each of the input array elements
    for (int i = 0; i < n; i++)
        threads[i] = (HANDLE)_beginthread(&routine, 0,  &arr[i]);

    // Process these threads
    WaitForMultipleObjects(n, threads, TRUE, INFINITE);
    return;
}

int main()
{
    // Doesn't work for negative numbers
    int arr[] = {34, 23, 122, 9};
    int n = sizeof(arr) / sizeof(arr[0]);

    sleepSort (arr, n);

    return(0);
}
