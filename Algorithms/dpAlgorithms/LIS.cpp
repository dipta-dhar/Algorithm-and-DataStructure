#include<bits/stdc++.h>
using namespace std;

void printoutput(int *arr, int *out, int curi);

int main()
{
    int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    int *res;
    int *out;

    int len = sizeof(arr)/sizeof(arr[0]);
    int max = len > 0 ? 1 : 0;
    int n = 1;
    int maxi = 0;
    int i,j;

    res = (int*)malloc(sizeof(int) * len);
    out = (int*)malloc(sizeof(int) * len);
    for (i=0; i < len; i++) {
        res[i] = 1;
        out[i] = -1;
    }

    for (i = 1; i < len; i++) {
        n = res[i];
        for (j = 0; j < i; j++) {
            if ((arr[i] > arr[j]) && (res[j] >= n)) {
                n = res[j] + 1;
                out[i] = j;
            }
        }
        res[i] = n;
        if (n > max) {
            maxi = i;
            max = n;
        }
    }

    printf("The LIS length is: %d\n", max);
    printf("LIS value is:\n");
    if (len != 0)
        printoutput(arr, out, maxi);
    printf("\n");

    return 0;
}

void printoutput(int *arr, int *out, int curi) {
    if (curi < 0)
        return;

    if (out[curi] != -1) {
        printoutput(arr, out, out[curi]);
    }
    printf("%d ", arr[curi]);
}
