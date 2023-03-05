#include <iostream>

using namespace std;

int func2(int arr[], int N) {
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (i == j) continue;
            if (arr[i] + arr[j] == 100) return 1;
        }
    }
    return 0;
}

int main() {
    int arr1[] = {1, 52, 48};
    int arr2[] = {50, 42};
    int arr3[] = {4, 13, 63, 87};

    cout << func2(arr1, 3) << endl;
    cout << func2(arr2, 2) << endl;
    cout << func2(arr3, 4) << endl;
}