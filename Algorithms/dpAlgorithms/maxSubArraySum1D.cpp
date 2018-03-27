#include<bits/stdc++.h>
using namespace std;

int maxSubArraySum(int [], int );
int maxSubArraySumWithIndex(int [], int );

int main()
{
   int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};

   int n = sizeof(a)/sizeof(a[0]);
   int max_sum = maxSubArraySumWithIndex(a, n);

   cout << "Maximum contiguous sum is: " << max_sum << endl;
   return 0;
}

int maxSubArraySum(int a[], int size) {
   int max_so_far = a[0];
   int curr_max = a[0];

   for (int i = 1; i < size; i++) {
        curr_max = max(a[i], curr_max+a[i]);
        max_so_far = max(max_so_far, curr_max);
   }

   return max_so_far;
}

int maxSubArraySumWithIndex(int a[], int size) {
    int max_so_far = INT_MIN, max_ending_here = 0,
       start =0, end = 0, s=0;

    for (int i=0; i< size; i++ ) {
        max_ending_here += a[i];

        if (max_so_far < max_ending_here) {
            max_so_far = max_ending_here;
            start = s;
            end = i;
        }

        if (max_ending_here < 0) {
            max_ending_here = 0;
            s = i + 1;
        }
    }
    cout << "Starting index: "<< start << endl << "Ending   index: "<< end << endl;

    return max_so_far;
}
