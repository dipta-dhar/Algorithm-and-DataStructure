#include<bits/stdc++.h>
using namespace std;

#define size 10000

int arr[size], n;

void BubbleSort(int arr[], int n) {
	int i, j;
	for (i=0; i<n; ++i) {
		for (j=0; j<n-i-1; ++j) {
			if (arr[j] > arr[j+1]) {
                int tem = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tem;
			}
		}
	}
}

void getInput() {
    printf("Enter Total number of elements: ");
	scanf("%d", &n);

	printf("Enter %d numbers:\n", n);
	for(int i=0; i<n; i++) {
		scanf("%d", &arr[i]);
	}
}

void showOutput() {
    printf("After Sorting:\n", n);
	for(int i=0; i<n; i++) {
		printf("%d  ", arr[i]);
	} 
}

int main() {
	getInput();
    BubbleSort(arr, n);
    showOutput();

	return 0;
}
