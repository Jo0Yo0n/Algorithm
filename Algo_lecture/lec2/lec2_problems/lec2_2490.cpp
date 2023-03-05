#include <iostream>
#include <numeric>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[4];
    int sum = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> arr[j];
        }

        sum = accumulate(begin(arr), end(arr), 0);

        if (sum == 3) {
            cout << "A" << '\n';
        } else if (sum == 2) {
            cout << "B" << '\n';
        } else if (sum == 1) {
            cout << "C" << '\n';
        } else if (sum == 0) {
            cout << "D" << '\n';
        } else if (sum == 4) {
            cout << "E" << '\n';
        }
    }
}