#include <stdio.h>
#include <stdlib.h>

int newgap(int gap) {
    gap = (gap * 10) / 13;
    if (gap == 9 || gap == 10)
        gap = 11;
    if (gap < 1)
        gap = 1;
    return gap;
}

void combsort(int a[], int aSize) {
    int gap = aSize;
    int temp, i;

    while(true) {
        gap = newgap(gap);
        int swapped = 0;
        for (i = 0; i < aSize - gap; i++) {
            int j = i + gap;
            if (a[i] > a[j]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                swapped  =  1;
            }
        }
        if (gap  ==  1 && !swapped)
            break;
    }
}
int main ()
{
    int n, i, a[100];
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    printf("Enter the elements:\n");
    for(i=0; i<n; i++)
        scanf("%d", &a[i]);

    printf("\nBefore Sorting:\n");
    for(i=0; i<n; i++)
        printf("%d ", a[i]);

    combsort(a, n);

    printf("\n\nAfter Sorting:\n");
    for(i = 0;i < n;i++)
        printf("%d ", (a[i]));

    return 0;
}
