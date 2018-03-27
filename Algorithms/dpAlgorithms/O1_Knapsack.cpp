#include<cstdio>
#define max(a,b) ((a)>(b) ? (a):(b))
using namespace std;

int knapSack(int MW, int weight[], int price[], int N) {
    int i,w;
    int K[N+1][MW+1];
    for(i=0; i<=N; i++) {
        for(w=0; w<=MW; w++) {
            if (i==0 || w==0)           K[i][w] = 0;
            else if (weight[i-1] <= w)  K[i][w] = max(price[i-1]+K[i-1][w-weight[i-1]], K[i-1][w]);
            else                        K[i][w] = K[i-1][w];
        }
    }

    return K[N][MW];
}

int main()
{
    int price[]  = {60, 100, 120};
    int weight[] = {2, 1, 4};
    int  MW = 6;

    int N = sizeof(price)/sizeof(price[0]);
    printf("%d", knapSack(MW, weight, price, N));

    return 0;
}
