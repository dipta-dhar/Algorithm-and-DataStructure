#include<bits/stdc++.h>
using namespace std;

void countingSort(int arr[], int n, int max) {
    int i, j;
    int B[20], C[100];

    for(i=0; i<=max; i++)   C[i] = 0;
    for(j=1; j<=n; j++)     C[arr[j]] = C[arr[j]] + 1;
    for(i=1; i<=max; i++)   C[i] = C[i] + C[i-1];
    for(j=n; j>=1; j--) {
        B[C[arr[j]]] = arr[j];
        C[arr[j]] = C[arr[j]] - 1;
    }

    printf("The Sorted array is:\n");
    for(i=1; i<=n; i++)
          printf("%d ", B[i]);
    return;
}

int main()
{
    int a[50],n,i,max=0;
    printf("Enter number of elements: ");
    scanf("%d",&n);

    printf("Enter elements:\n");
    for(i=1; i<=n; ++i) {
        scanf("%d",&a[i]);
        if(a[i] > max)
            max = a[i];
    }

    countingSort(a, n, max);

    return 0;
}
