#include<bits/stdc++.h>
using namespace std;

void binarySearch(int arr[], int n, int searchValue) {
    int first = 0;
    int last = n - 1;
    int middle = (first+last)/2;

    while(first <= last) {
        if (arr[middle] < searchValue)
            first = middle + 1;

        else if (arr[middle] == searchValue) {
            printf("%d is found at location %d.\n", searchValue, middle+1);
            return;
        }
        else last = middle - 1;

        middle = (first + last)/2;
    }
    printf("%d isn't present in the array.\n", searchValue);
}


int main()
{
    int arr[100], n, searchValue;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);

    printf("Enter the search value: ");
    scanf("%d", &searchValue);

    sort(arr, arr+n);
    printf("\n\nSorting list is:\n", n);
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n\n");

    binarySearch(arr, n, searchValue);

    return 0;
}
