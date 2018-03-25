#include<bits/stdc++.h>
using namespace std;

//Performs a shell sort
void shellSort(int array[], int n) {
    int h = 1;
    while (h < n) h = 3*h + 1;
    while (h > 0)
    {
        h = h/3;
        for (int k = 0; k < h; k++)
        {
            for (int i = h+k; i<n; i+=h)
            {
                int key = array[i];
                int j = i-h;
                while (j>=0 && array[j] > key)
                {
                    array[j+h] = array[j];
                    j-=h;
                }
                array[j+h] = key;
                //-> invariant: array[0,h,2*h..j] is sorted
            }
        }
        //->invariant: each h-sub-array is sorted
    }
}

int main()
{
    int a[] = {9,8,7,6,5,4,3,2,1};
    int n = sizeof a / sizeof a[0];

    printf("Before Shell Sort:\n");
    for(int i=0; i<n; i++)
        printf("%d ", a[i]);

    shellSort(a, n);

    printf("\n\nAfter Shell Sort:\n");
    for(int i=0; i<n; i++)
        printf("%d ", a[i]);

    return 0;
}

