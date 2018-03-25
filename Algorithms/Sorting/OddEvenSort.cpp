#include<bits/stdc++.h>
using namespace std;

void swap(int *, int *);
void oddevenSort(int *, int );

int main()
{
    int a[1000], i, n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    printf("Enter elements:\n");
    for (i=0; i < n; i++)
        scanf("%d", &a[i]);

    oddevenSort(a, n);

    printf("Sorted elements are:\n");
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);

    return 0;
}

void swap(int * x, int * y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

void oddevenSort(int *x, int n) {
    int sort = 0, i;
    while (!sort) {
        sort = 1;
        for (i=1; i<n-1; i += 2) {
            if (x[i] > x[i+1]) {
                swap(&x[i], &x[i+1]);
                sort = 0;
            }
        }

        for (i = 0; i<n; i += 2) {
            if (x[i] > x[i + 1]) {
                swap(&x[i], &x[i + 1]);
                sort = 0;
            }
        }
    }
}
