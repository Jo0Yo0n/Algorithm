#include <bits/stdc++.h>
using namespace std;

int func2(int arr[], int N) {
    int bucket[101] = {};
    for (int i = 0; i < N; i++) {
        if (bucket[100 - arr[i]] == 1) {
            return 1;
        }
        bucket[arr[i]] = 1;
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr1[10] = {1, 52, 48};
    int arr2[10] = {50, 42};
    int arr3[10] = {4, 13, 63, 87};

    cout << func2(arr1, 3) << '\n';
    cout << func2(arr2, 2) << '\n';
    cout << func2(arr3, 4) << '\n';
}