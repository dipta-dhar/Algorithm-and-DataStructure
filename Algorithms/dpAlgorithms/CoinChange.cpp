#include<bits/stdc++.h>
using namespace std;

int coins[] = {1, 5, 10, 25, 50};
int dp[7500][5];

int coinChange(int amount, int index) {
    if (amount == 0)                return 1;
    if (dp[amount][index] != -1)    return dp[amount][index];

    int ways = 0;
    for (int i=index; i<5; ++i) {
        if (amount >= coins[i])
            ways += coinChange(amount - coins[i], i);
    }

    return dp[amount][index] = ways;
}

int main() {
    //freopen("in.txt", "r", stdin);
    //freopen("out.txt", "w", stdout);

    int amount;
    memset(dp, -1, sizeof dp);
    while (scanf("%d", &amount) == 1) {
        printf("%d\n",coinChange(amount, 0));
    }
    return 0;
}
