#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[3];
    for (int i = 0; i < 3; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < 3; i++) {
        int j;
        for (j = i + 1; j < 3; j++) {
            if (arr[i] > arr[j]) {
                swap(arr[i], arr[j]);
            }
        }
    }

    for (int i = 0; i < 3; i++) {
        cout << arr[i] << ' ';
    }
}

void swap(int& a, int& b) {
    int temp;
    temp = a;
    a = b;
    b = temp;
}