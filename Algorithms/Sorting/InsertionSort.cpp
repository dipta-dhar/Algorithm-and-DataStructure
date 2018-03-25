/* Insertion sort ascending order */

#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n, array[1000], c, d;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d integers\n", n);
    for (c=0; c<n; c++)
        scanf("%d", &array[c]);

    for(c=1 ; c <= n-1; c++) {
        d = c;
        while(d>0 && array[d-1]>array[d]) {
            int tem    = array[d];
            array[d]   = array[d-1];
            array[d-1] = tem;
            d--;
        }
    }

    printf("The Sorted elements are:\n");
    for (c=0; c<n; c++)
        printf("%d ", array[c]);

    return 0;
}
