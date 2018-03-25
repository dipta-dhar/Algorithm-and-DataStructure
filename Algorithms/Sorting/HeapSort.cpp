#include<bits/stdc++.h>
using namespace std;

void heapsort(int[], int);
void heapify(int[], int);
void adjust(int[], int);

int main() {
	int n,i,a[50];
	printf("Enter the number of total elements: ");
	scanf("%d", &n);

	printf("Enter the elements:\n");
	for (i=0; i<n; i++)
	  scanf("%d", &a[i]);

	heapsort(a, n);
	printf("The Sorted elements are:\n");
	for (i=0; i<n; i++)
	  printf("%d  ", a[i]);
	printf("\n");
}
void heapsort(int a[], int n) {
	int i,t;
	heapify(a,n);
	for (i=n-1; i>0; i--) {
		t = a[0];
		a[0] = a[i];
		a[i] = t;
		adjust(a, i);
	}
}
void heapify(int a[],int n) {
	int k,i,j,item;
	for (k=1; k<n; k++) {
		item = a[k];
		i = k;
		j = (i-1)/2;
		while((i>0) && (item>a[j])) {
			a[i] = a[j];
			i = j;
			j = (i-1)/2;
		}
		a[i] = item;
	}
}
void adjust(int a[], int n) {
	int i,j,item;
	j = 0;
	item = a[j];
	i = 2*j+1;
	while(i<=n-1) {
		if(i+1 <= n-1)
		   if(a[i] <a[i+1])
		    i++;
		if(item<a[i]) {
			a[j] = a[i];
			j = i;
			i = 2*j+1;
		} else
		   break;
	}
	a[j] = item;
}
