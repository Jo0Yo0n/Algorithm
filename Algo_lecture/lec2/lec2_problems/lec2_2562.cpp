#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int max = 0, x, index;

    for (int i = 1; i <= 9; i++) {
        cin >> x;
        if (x > max) {
            index = i;
            max = x;
        }
    }
    cout << max << '\n'
         << index;
}