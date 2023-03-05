#include <bits/stdc++.h>
using namespace std;

int main() {
    int x, sum = 0, remain = 0;
    bool flag = false;
    vector<int> arr;

    for (int i = 0; i < 9; i++) {
        cin >> x;

        sum += x;
        arr.push_back(x);
    }

    sort(arr.begin(), arr.end());

    for (int i = 0; i < 8; i++) {
        if (arr[i] >= remain) continue;

        for (int j = i + 1; j < 9; j++) {
            if (arr[j] >= remain) continue;

            if (sum - arr[i] - arr[j] == 100) {
                flag = true;
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) continue;
                    cout << arr[k] << '\n';
                }
                break;
            }
        }
        if (flag) break;
    }
}