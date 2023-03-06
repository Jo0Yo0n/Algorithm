#include <bits/stdc++.h>
using namespace std;

int func2(int arr[], int N) {
    int occur[101] = {};

    for (int i = 0; i < N; i++) {
        if (occur[100 - arr[i]] == 1)
            return 1;
        occur[arr[i]] = 1;
    }
    return 0;
}

int main() {
    int arr[] = {1, 99, 3};

    cout<< func2(arr, 3);
}