#include<bits/stdc++.h>
using namespace std;

int lps(char *);

int main()
{
    char str[] = "abcdeRTONUedcba";
    int lps_len = lps(str);
    printf ("Length of Longest palindromic subsequence is: %d\n", lps_len);

    return 0;
}

int lps(char *str) {
   int n = strlen(str);
   int i, j, cl;
   int L[n][n];


   // Strings of length 1 are palindrome of length 1
   for(i = 0; i < n; i++)
      L[i][i] = 1;

    for(cl=2; cl<=n; cl++) {
        for(i=0; i<n-cl+1; i++) {
            j = i+cl-1;

            if (str[i] == str[j] && cl == 2)    L[i][j] = 2;
            else if (str[i] == str[j])          L[i][j] = L[i+1][j-1] + 2;
            else                                L[i][j] = max(L[i][j-1], L[i+1][j]);
        }
    }

    return L[0][n-1];
}

