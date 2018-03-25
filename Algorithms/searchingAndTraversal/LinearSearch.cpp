#include<bits/stdc++.h>
using namespace std;

void linearSearch(int arr[], int n, int searchValue) {
    for(int i=0; i<n; i++) {
        if (arr[i] == searchValue) {
            printf("%d is present at location %d.\n", arr[i], i+1);
            return;
        }
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

    linearSearch(arr, n, searchValue);

    return 0;
}
